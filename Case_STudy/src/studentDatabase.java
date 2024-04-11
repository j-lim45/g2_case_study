import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.time.LocalDate;
import java.util.*;
import java.io.*;

class studentDatabase extends CourseDatabase {
    int studentID; String lastName; String firstName; LocalDate birthday; String address; String guardian; double gwa; int[] courseGrade = new int[8];  
    static CSVReader csvReader = null;                                                                                          
    studentDatabase() {
    }

    studentDatabase(int id, String ln, String fn, LocalDate bd, String a, String g, double gwa, int[] cg) {                                                  
        studentID = id;
        lastName = ln;
        firstName = fn;
        birthday = bd;
        address = a;
        guardian = g;
        courseGrade = cg;
    }

    static ArrayList<studentDatabase> getStudentList() {
        ArrayList<studentDatabase> studentList = new ArrayList<studentDatabase>();
        return studentList;
    }

    static void createNewDatabase() {
        String file = "database.csv"; File databaseFile = new File(file);

        try {
            csvReader = new CSVReaderBuilder(new FileReader(databaseFile))
            .withCSVParser(new CSVParserBuilder()
                .withSeparator(';')
                .build())
            .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            databaseFile.createNewFile();
        } catch (IOException ioe) {
            System.out.println("An error occured in creating database.");
        }

        readDatabase(getStudentList());
    }

    static void readDatabase(ArrayList<studentDatabase> studentList) {                                                          
        String[] cellRow; 

        try {
            int databaseIndex = 0;
            while ((cellRow = csvReader.readNext()) != null) {
                studentList.add(new studentDatabase());                              
                studentList.get(databaseIndex).studentID = Integer.parseInt(cellRow[0]);
                studentList.get(databaseIndex).lastName = cellRow[1];
                studentList.get(databaseIndex).firstName = cellRow[2];
                studentList.get(databaseIndex).birthday = LocalDate.of(Integer.parseInt(cellRow[3]), Integer.parseInt(cellRow[4]),Integer.parseInt(cellRow[5]));
                studentList.get(databaseIndex).address = cellRow[6];
                studentList.get(databaseIndex).guardian = cellRow[7];
                studentList.get(databaseIndex).gwa = Double.parseDouble(cellRow[8]);

                int j = 9;
                for (int i = 0; i < 8; i++) {
                    studentList.get(databaseIndex).courseGrade[i] = Integer.parseInt(cellRow[j]);
                    j++;
                }

                databaseIndex++;
            }
            csvReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (CsvValidationException csv) {
            csv.printStackTrace();
        }   
    }

    static void writeUserToFile(String lineToWrite) {
        BufferedReader br = null; BufferedWriter bw = null;
        int rowIndex = 0;
        try {
            br = new BufferedReader(new FileReader(new File("database.csv")));
            bw = new BufferedWriter(new FileWriter(new File("database.csv"), true));
            while ((br.readLine()) != null) {
                rowIndex++; 
            }
            
            if (rowIndex > 0) bw.newLine();
            bw.write(lineToWrite); br.close(); bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printAll(ArrayList<studentDatabase> studentList) {
        System.out.println("LAST NAME\tFIRST NAME\tADDRESS\tGUARDIAN");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).lastName + "\t" + studentList.get(i).firstName + "\t" + studentList.get(i).address + "\t" + studentList.get(i).guardian);
        }
        Scan.caro.next();
    }

}
