import com.opencsv.*; // Imports opencsv module to parse csv files
import com.opencsv.exceptions.CsvValidationException; // imports an opencsv exception in case may it finds exception that is specific t csv

import java.time.LocalDate; // imports the localdate class to parse calendar date
import java.util.*; // scanner and arraylistt
import java.io.*; // for importing filereader, bufferedreader, bufferedwriter, etc.

class studentDatabase { 
    int studentID; String lastName; String firstName; LocalDate birthday; String address; String guardian; double gwa; int[] courseGrade = new int[8];  
    static CSVReader csvReader = null;                                                                                          
    studentDatabase() { // constructor with no parameters
    }

    studentDatabase(int id, String ln, String fn, LocalDate bd, String a, String g, double gwa, int[] cg) {    // constructor that sets the attributes for the objects in the ArrayList studentList                                               
        studentID = id;
        lastName = ln;
        firstName = fn;
        birthday = bd;
        address = a;
        guardian = g;
        courseGrade = cg;
    }

    static ArrayList<studentDatabase> getStudentList() { // get method to get studentlist
        ArrayList<studentDatabase> studentList = new ArrayList<studentDatabase>(); // contains the objects (students) which holds a lot of attributes such as studentID, lastName, firstName, etc.
        return studentList;
    }

    static void createNewDatabase() { // class to create new File class and database.csv file
        String file = "database.csv"; File databaseFile = new File(file);

        try { // csvreader setup
            csvReader = new CSVReaderBuilder(new FileReader(databaseFile))
            .withCSVParser(new CSVParserBuilder()
                .withSeparator(';')
                .build())
            .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try { // method to create new file
            databaseFile.createNewFile();
        } catch (IOException ioe) {
            System.out.println("An error occured in creating database.");
        }

        readDatabase(getStudentList());
    }

    static void readDatabase(ArrayList<studentDatabase> studentList) { // reads every line in the database.csv file to parse into studentList arrayList                                                    
        String[] cellRow; // String that will hold the String for each row in the database.csv file

        try {
            int databaseIndex = 0;
            while ((cellRow = csvReader.readNext()) != null) { // while (csvReader does not read a line that contains nothing) { convert the line contents into each attributes of every object (student)  }
                studentList.add(new studentDatabase());                              
                studentList.get(databaseIndex).studentID = Integer.parseInt(cellRow[0]);
                studentList.get(databaseIndex).lastName = cellRow[1];
                studentList.get(databaseIndex).firstName = cellRow[2];
                studentList.get(databaseIndex).birthday = LocalDate.of(Integer.parseInt(cellRow[3]), Integer.parseInt(cellRow[4]),Integer.parseInt(cellRow[5]));
                studentList.get(databaseIndex).address = cellRow[6];
                studentList.get(databaseIndex).guardian = cellRow[7];
                studentList.get(databaseIndex).gwa = Double.parseDouble(cellRow[8]);
                // reads the individual course grade cells in the file to convert to an array of grades
                int j = 9;
                for (int i = 0; i < 8; i++) {
                    studentList.get(databaseIndex).courseGrade[i] = Integer.parseInt(cellRow[j]);
                    j++;
                }

                databaseIndex++; // i think this code is useless but im not sure
            }
            csvReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (CsvValidationException csv) {
            csv.printStackTrace();
        }   
    }

    static void writeUserToFile(String lineToWrite) { // writes the line of the user input when adding user to the next empty line in the file
        BufferedReader br = null; BufferedWriter bw = null;
        int rowIndex = 0;
        try {
            br = new BufferedReader(new FileReader(new File("database.csv")));
            bw = new BufferedWriter(new FileWriter(new File("database.csv"), true));
            while ((br.readLine()) != null) { // while (bufferedreader does not read a line that doesnt contain nothing) { add number of lines read by the bufferedreader by 1 }
                rowIndex++; 
            }
            
            if (rowIndex > 0) bw.newLine(); // writes a new line after the last row of content so that it doesnt overwrite it
            bw.write(lineToWrite); br.close(); bw.close(); // writes the actual line

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
