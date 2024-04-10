import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

class studentDatabase extends CourseDatabase {
    int studentID; String lastName; String firstName; LocalDate birthday; String address; String guardian; double gwa; int[] courseGrade = new int[8];  // Student attributes
    static CSVReader csvReader = null;                                                                                              // I placed CSVReader here because I don't want to keep passing it through methods so I made it static

    studentDatabase() {
    }

    studentDatabase(int id, String ln, String fn, LocalDate bd, String a, String g, double gwa, int[] cg) {                                                   // constructor
        studentID = id;
        lastName = ln;
        firstName = fn;
        birthday = bd;
        address = a;
        guardian = g;
        courseGrade = cg;
    }

    static void createNewDatabase(File databaseFile) {                                                                              // METHOD - if database.csv was not found in the specified directory, create a new one
        try {
            System.out.println(databaseFile.createNewFile());
        } catch (IOException ioe) {
            System.out.println("An error occured in creating database.");
            ioe.printStackTrace();
        }
    }

    static void readDatabase(ArrayList<studentDatabase> studentList) {                                                              // METHOD - Reads database.csv and converts the text into objects to be added to the studentList ArrayList
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



    static studentDatabase addUser(BufferedWriter bw) {
        int studentID; String lastName; String firstName; String address; String guardian; int[] birthday = new int[3]; double gwa = 0; int[] grades = new int[8];
        String errorMessage = ""; String choice;

        while (true) {
            System.out.print("Input Student ID: ");
            studentID = Scan.caro.nextInt();
            break;
        }

        while (true) {
            System.out.print("Input Last Name: "); Scan.caro.nextLine();
            lastName = Scan.caro.nextLine().toUpperCase();
            break;
        }

        while (true) {
            System.out.print("Input First Name: ");
            firstName = Scan.caro.nextLine().toUpperCase();
            break;
        }

        while (true) {
            System.out.print("Input Year of Birth: "); birthday[0] = Scan.caro.nextInt();
            System.out.print("Input Month of Birth: "); birthday[1] = Scan.caro.nextInt();
            System.out.print("Input Day of Birth: "); birthday[2] = Scan.caro.nextInt();
            
            try {
                LocalDate.of(birthday[0], birthday[1], birthday[2]);
                break;
            } catch (DateTimeException dte) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        while (true) {
            System.out.print("Input Address: "); Scan.caro.nextLine();
            address = Scan.caro.nextLine().toUpperCase();
            break;
        }

        while (true) {
            System.out.print("Input Guardian Name: ");
            guardian = Scan.caro.nextLine().toUpperCase();
            break;
        }
        String lineToWrite = 
        studentID + ";" + lastName + ";" + firstName + ";" + 
        birthday[0] + ";" + birthday[1] + ";" + birthday[2] + 
        ";" + address + ";" + guardian + ";";

        System.out.print("Do you want to input your grades?"); 
        errorMessage = "";
        while (true) {
            System.out.println(errorMessage);
            System.out.print("Input [Y/N]: "); choice = Scan.caro.next().toUpperCase(); System.out.println(choice);
                if (choice.equals("Y")) {
                    grades = CourseDatabase.inputGrades();

                    for (int i = 0; i < grades.length; i++) {
                        gwa += grades[i];
                    }
                    gwa /= grades.length;

                    break;
                } else if (choice.equals("N")) {
                    for (int i = 0; i < grades.length; i++) {
                        grades[i] = -1;
                    }
                    gwa = -1;
                    break;
                } else errorMessage = "Invalid Choice";
            }

            lineToWrite += gwa;
        for (int i = 0; i < grades.length; i++) {
            lineToWrite += ";" + grades[i];
        }

        
        try {
            while ((csvReader.readNext()) != null) {System.out.println("Did u even do anything");}
            bw.newLine(); // fix nothing on line 1
            bw.write(lineToWrite); bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new studentDatabase(studentID, lastName, firstName, LocalDate.of(birthday[0], birthday[1], birthday[2]), address, guardian, gwa, grades);
    }  
    

    static void printAll(ArrayList<studentDatabase> studentList) {
        System.out.println("LAST NAME\tFIRST NAME\tADDRESS\tGUARDIAN");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).lastName + "\t" + studentList.get(i).firstName + "\t" + studentList.get(i).address + "\t" + studentList.get(i).guardian);
        }
        Scan.caro.next();
    }


    public static void main(String[] args) {
        ArrayList<studentDatabase> studentList = new ArrayList<studentDatabase>(); CourseDatabase.addCourse();
        String file = "database.csv"; 
        File databaseFile = new File(file);
        BufferedWriter bWriter = null;

        try {
            bWriter = new BufferedWriter(new FileWriter(databaseFile, true)); 
            csvReader = new CSVReaderBuilder(new FileReader(databaseFile))
            .withCSVParser(new CSVParserBuilder()
                .withSeparator(';')
                .build())
            .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        createNewDatabase(databaseFile); readDatabase(studentList);

        int choice = 10; String errorMessage = "";
        while (true) {
            clearConsole.main();
            System.out.println("[1] Add User\n[2] Check Database");
            System.out.println(errorMessage);
            System.out.print("Input choice: ");
            
            try {
                choice = Scan.caro.nextInt();
            } catch (InputMismatchException nfe) {
                errorMessage = "Input is not an integer";
                Scan.caro.next();
            }

            if (choice == 1) {
                clearConsole.main();
                studentList.add(addUser(bWriter));
            } else if (choice == 2) {
                clearConsole.main();
                printAll(studentList);
            } else if (choice == 0) {
                break;
            }
        }
    }
}
