import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

class Menu {

    static void subMenu1() {
        String errorMessage = ""; String choice;
        while (true) {
            clearConsole.main(); displayLogo(); displaySubMenu1();
            System.out.println(errorMessage);
            System.out.print("\n\t\t\b\bEnter your choice: "); choice = Scan.caro.next();
            if (choice.equals("1")) {
                addUser();
                errorMessage = "";
            } else if (choice.equals("2")) editUser(studentDatabase.getStudentList());
            else if (choice.equals("0"))    break;
            else errorMessage = "ERROR: Invalid input. Please enter a valid option. [0-2]";
        }
    }

    static void displayLogo() {
        System.out.println(
            "╔====================================================╗\n" +
            "║    ____                                  _  _      ║\n" +
            "║   / ___|__ _ _ __ ___  _ __  _   _ ___ _| || |_    ║\n" +
            "║  | |   / _` | '_ ` _ \\| '_ \\| | | / __|_  ..  _|   ║\n" +
            "║  | |__| (_| | | | | | | |_) | |_| \\__ \\_      _|   ║\n" +
            "║   \\____\\__,_|_| |_| |_| .__/ \\__,_|___/ |_||_|     ║\n" +  
            "║                       |_|                          ║\n" +
            "╚====================================================╝");
    }

    static void displayMenu() {
        System.out.println("|                     MAIN MENU                      |");
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                                                    |");
        System.out.println("|             [1] Add/Edit/Delete User               |");
        System.out.println("|             [2] View Database                      |");
        System.out.println("|             [0] EXIT                               |");
        System.out.println("|                                                    |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void displaySubMenu1() {
        System.out.println("|                ADD/EDIT/DELETE USER                |");
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                                                    |");
        System.out.println("|             [1] Add User                           |");
        System.out.println("|             [2] Edit User Field                    |");
        System.out.println("|             [3] Delete User                        |");
        System.out.println("|             [0] BACK                               |");
        System.out.println("|                                                    |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void addUser() {
        int studentID = 0; String lastName = ""; String firstName = ""; String address; String guardian = ""    ; int[] birthday = new int[3]; double gwa = 0; int[] grades = new int[8];
        String invalidCharacters = ";\\\"\',./<>?|`~1234567890!@#$%^&*()_+-=[]{}";
        String errorMessage = "";

        // ID NUMBER
        while (true) {
            clearConsole.main(); displayLogo(); menuTab("|                 Enter ID Number:                   |\n|(ID must be 8 characters long and starts with '209')|", errorMessage);
            try {
                System.out.print("Enter ID: "); studentID = Scan.caro.nextInt();
            } catch (Exception e) {
                errorMessage = "ERROR: ID Number is not a valid input."; Scan.caro.next();
            }
            if      (String.valueOf(studentID).length() != 8)               errorMessage = "ERROR: ID Number must be 8 numbers long.";
            else if (!String.valueOf(studentID).startsWith("209"))   errorMessage = "ERROR: ID Number must start with \"209\".";
            else                                                            break;
        }
        Scan.caro.nextLine();
        // LAST NAME
        errorMessage = ""; boolean invalid = true;
        while (invalid) {
            clearConsole.main(); displayLogo(); menuTab("|                 Enter Last Name:                   |", errorMessage);

            System.out.print("Input Last Name: ");
            lastName = Scan.caro.nextLine().toUpperCase();

            invalid = false;
            for (int i = 0; i < lastName.length(); i++) {
                for (int j = 0; j < invalidCharacters.length(); j++) {
                    if (lastName.charAt(i) == invalidCharacters.charAt(j)) {
                        errorMessage = "ERROR: Input contains illegal characters.";
                        invalid = true;
                        break;
                    }
                }
                if (invalid) break;
            }
        }

        // FIRST NAME
        errorMessage = ""; invalid = true;
        while (invalid) {
            clearConsole.main(); displayLogo(); menuTab("|                 Enter First Name:                  |", errorMessage);

                System.out.print("Input First Name: ");
                firstName = Scan.caro.nextLine().toUpperCase();

                invalid = false;
                for (int i = 0; i < firstName.length(); i++) {
                    for (int j = 0; j < invalidCharacters.length(); j++) {
                        if (firstName.charAt(i) == invalidCharacters.charAt(j)) {
                            errorMessage = "ERROR: Input contains illegal characters.";
                            invalid = true;
                            break;
                        }
                    }
                    if (invalid) break;
                }
        }

        // BIRTHDAY 
        errorMessage = "";
        while (true) {
                try {
                    clearConsole.main(); displayLogo(); menuTab("|          Enter Year of Birth (e.g '1986')          |", errorMessage);
                    System.out.print("Input Year: "); birthday[0] = Scan.caro.nextInt();
                    errorMessage = "";
                    clearConsole.main(); displayLogo(); menuTab("|       Enter Month of Birth (e.g '5' for May)       |", errorMessage);
                    System.out.print("Input Month of Birth: "); birthday[1] = Scan.caro.nextInt();
                    errorMessage = "";
                    clearConsole.main(); displayLogo(); menuTab("|     Enter Day of Birth (e.g '15' for May 15th)     |", errorMessage);
                    System.out.print("Input Day of Birth: "); birthday[2] = Scan.caro.nextInt();
                    errorMessage = "";
                    LocalDate.of(birthday[0], birthday[1], birthday[2]);
                    break;
                } catch (DateTimeException dte) {
                    errorMessage = "Invalid date format. Please try again.";
                } catch (Exception e) {
                    errorMessage = "Invalid Input. Please input correctly."; Scan.caro.next();
                }
            }

        // ADDRESS
        errorMessage = "";
        while (true) {
            clearConsole.main(); displayLogo(); menuTab("| Enter City Address (e.g 'Municipality of Angeles') |", errorMessage);
            System.out.print("Input Address: "); Scan.caro.nextLine();
            address = Scan.caro.nextLine().toUpperCase();
            break;
        }

        // GUARDIAN NAME
        errorMessage = ""; invalid = true;
        while (invalid) {
            clearConsole.main(); displayLogo(); menuTab("|     Enter Guardian Name (e.g 'JUAN DELA CRUZ')     |", errorMessage);

            System.out.print("Input Guardian: ");
            guardian = Scan.caro.nextLine().toUpperCase();

            invalid = false;
            for (int i = 0; i < guardian.length(); i++) {
                for (int j = 0; j < invalidCharacters.length(); j++) {
                    if (guardian.charAt(i) == invalidCharacters.charAt(j)) {
                        errorMessage = "ERROR: Input contains illegal characters.";
                        invalid = true;
                        break;
                    }
                }
                if (invalid) break;
            }
        }

        String lineToWrite = 
        studentID + ";" + lastName + ";" + firstName + ";" + 
        birthday[0] + ";" + birthday[1] + ";" + birthday[2] + 
        ";" + address + ";" + guardian + ";";

        errorMessage = ""; String choice;
        while (true) {
            clearConsole.main(); displayLogo(); menuTab("|        Do you want to input your grades?           |", errorMessage);
            System.out.print("Input [Y/N]: "); choice = Scan.caro.next().toUpperCase();
                if (choice.equals("Y")) {
                    grades = CourseDatabase.inputGrades();

                    for (int i = 0; i < grades.length; i++) {
                        gwa += grades[i];
                    }
                    gwa /= grades.length;

                    break;
                } else if (choice.equals("N")) {
                    for (int i = 0; i < grades.length; i++) {
                        grades[i] = 0;
                    }
                    gwa = 0;
                    break;
                } else errorMessage = "ERROR: Invalid Choice";
            }

            lineToWrite += gwa;
        for (int i = 0; i < grades.length; i++) {
            lineToWrite += ";" + grades[i];
        }

        studentDatabase.getStudentList().add(new studentDatabase(studentID, lastName, firstName, LocalDate.of(birthday[0], birthday[1], birthday[2]), address, guardian, gwa, grades));
        studentDatabase.writeUserToFile(lineToWrite);

        }

    static void editUser(ArrayList<studentDatabase> studentList) {
        String choice; String errorMessage = ""; setUserAttribute set = new setUserAttribute();
        while (true) {
            
            clearConsole.main(); displayLogo(); displayEditTab();
            int studentIndex = editUserTable(studentList);
            if (studentIndex == -1) break;

            int studentID = studentList.get(studentIndex).studentID;
            String lastName = studentList.get(studentIndex).lastName;
            String firstName = studentList.get(studentIndex).firstName;
            LocalDate birthday = studentList.get(studentIndex).birthday;
            String address = studentList.get(studentIndex).address;
            String guardian = studentList.get(studentIndex).guardian;
            int[] courseGrade = studentList.get(studentIndex).courseGrade;

            while (true) {
                clearConsole.main(); displayLogo(); displayEditTab();
                System.out.println("CHOOSE WHAT ATTRIBUTE TO EDIT [1-13]: ");
                System.out.printf("\n[1] Student ID: \r\t\t\t\t%s", studentID);
                System.out.printf("\n[2] Last Name: \r\t\t\t\t%s", lastName);
                System.out.printf("\n[3] First Name: \r\t\t\t\t%s", firstName);
                System.out.printf("\n[4] Birthday: \r\t\t\t\t%s", birthday);
                System.out.printf("\n[5] Address: \r\t\t\t\t%s", address);
                System.out.printf("\n[6] Guardian Name: \r\t\t\t\t%s", guardian);
                for (int i = 0; i < CourseDatabase.getCourseList().size(); i++) {
                    System.out.printf("\n[%d] %s Grade: \r\t\t\t\t%d", i+7, CourseDatabase.getCourseList().get(i).shortName, courseGrade[i]);
                }
                System.err.println("\n\n" + errorMessage);
                System.out.println("[1-13] to edit attribute. [X] to cancel. [CONFIRM] to confirm changes.");
                System.out.print("INPUT: "); choice = Scan.caro.next().toUpperCase();
                if (choice.equals("1")) {
                    studentID = set.setStudentID();
                    
                } else if (choice.equals("2")) {
                    lastName = set.setLastName();
                } else if (choice.equals("3")) {
                    firstName = set.setFirstName();
                } else if (choice.equals("4")) {
                    birthday =  set.setBirthday();
                } else if (choice.equals("5")) {
                    address = set.setAddress();
                } else if (choice.equals("6")) {
                    guardian = set.setGuardian();
                } else if (choice.equals("7")) {
                    courseGrade[0] = set.setCourseGrade(0);
                } else if (choice.equals("8")) {
                    courseGrade[1] = set.setCourseGrade(1);
                } else if (choice.equals("9")) {
                    courseGrade[2] = set.setCourseGrade(2);
                } else if (choice.equals("10")) {
                    courseGrade[3] = set.setCourseGrade(3);
                } else if (choice.equals("11")) {
                    courseGrade[4] = set.setCourseGrade(4);
                } else if (choice.equals("12")) {
                    courseGrade[5] = set.setCourseGrade(5);
                } else if (choice.equals("13")) {
                    courseGrade[6] = set.setCourseGrade(6);
                } else if (choice.equals("14")) {
                    courseGrade[7] = set.setCourseGrade(7);
                } else if (choice.equals("X")) {
                    break;
                } else if (choice.equals("CONFIRM")) {
                    double gwa = 0;
                    for (int i = 0; i < CourseDatabase.getCourseList().size(); i++) {
                        gwa += courseGrade[i];
                    }
                    gwa /= CourseDatabase.getCourseList().size();
                    
                    studentList.get(studentIndex).studentID = studentID;
                    studentList.get(studentIndex).lastName = lastName;
                    studentList.get(studentIndex).firstName = firstName;
                    studentList.get(studentIndex).birthday = birthday;
                    studentList.get(studentIndex).address = address;
                    studentList.get(studentIndex).guardian = guardian;
                    for (int i = 0; i < CourseDatabase.getCourseList().size(); i++) {
                        studentList.get(studentIndex).courseGrade[i] = courseGrade[i];
                    }
                    studentList.get(studentIndex).gwa = gwa;

                    studentDatabase.reWriteFile(studentList);
                    clearConsole.main(); displayLogo(); displayEditTab(); System.out.println("Changes succesfully made.");
                    System.out.print("\nInput any key to continue: "); Scan.caro.next();
                    break;
                }
                else {
                    errorMessage = "ERROR: Invalid input.";
                }
            }
            break;
        }

    }
    

    static void menuTab(String fieldPrompt, String errorMessage) {
        System.out.println("|                    ADD USER                        |");
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println(fieldPrompt);
        System.out.println("└────────────────────────────────────────────────────┘");
        System.err.println(errorMessage);
    }

    static void displayTableTab() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                  Database Table                    |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void displayEditTab() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                     EDIT USER                      |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void gradeReport(String name) {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.printf("|              %s GRADE REPORT\r\t\t\t\t\t\t\t\b\b\b|\n", name);
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static int editUserTable(ArrayList<studentDatabase> studentList) {
        int tab = 0; String choice; String errorMessage = "";
        while (true) {
            clearConsole.main(); displayLogo(); displayTableTab();
            System.out.println("  " + "STUDENT ID\tLAST NAME\tFIRST NAME\t\tBIRTHDAY\t\tADDRESS\t\t\tGUARDIAN NAME\t\tGWA");
            System.out.println("  " + "===============================================================================================================================================");

            for (int i = tab; i < tab+10; i++) {
                System.out.println("[" + (i+1) + "] " + studentList.get(i).studentID + "\t" + studentList.get(i).lastName + "\r\t\t\t\t" + studentList.get(i).firstName + "\r\t\t\t\t\t\t\t" + studentList.get(i).birthday + "\r\t\t\t\t\t\t\t\t\t\t" + studentList.get(i).address + "\r\t\t\t\t\t\t\t\t\t\t\t\t\t" + studentList.get(i).guardian + "\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\b" + String.format("%.2f", studentList.get(i).gwa));
                if (i == studentList.size()-1) break;
            }
            System.out.println("  " + "===============================================================================================================================================");
            if (tab > 0) {
                System.out.print("[BACK]");
            }
            if ((tab+9) < studentList.size()) {
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t[NEXT]");
            }
            System.err.println("\n" + errorMessage);
            System.out.print("Enter Index Number of Student to Edit Info. [BACK/NEXT] to navigate the table. [X] to go back.");
            System.out.print("\nInput: "); choice = Scan.caro.next().toUpperCase();
            try {
                if ((Integer.parseInt(choice)-1) >= 0 && (Integer.parseInt(choice)-1) <= studentList.size()) {
                    return Integer.parseInt(choice)-1;
                } else {
                    errorMessage = "ERROR: Index number does not exist.";
                }
            } catch (Exception e) {
                if (choice.equals("NEXT") && ((tab+9) < studentList.size())) {
                    tab += 9;
                    errorMessage = "";
                } else if (choice.equals("BACK") && (tab > 0)) {
                    tab -= 9;
                    errorMessage = "";
                } else if (choice.equals("X")) {
                    return -1;
                }
                else {
                    errorMessage = "ERROR: Invalid Choice";
                }
            }
        }
    }

    static void printDatabase(ArrayList<studentDatabase> studentList) {
        int tab = 0; String choice; String errorMessage = "";
        while (true) {
            clearConsole.main(); displayLogo(); displayTableTab();
            System.out.println("  " + "STUDENT ID\tLAST NAME\tFIRST NAME\t\tBIRTHDAY\t\tADDRESS\t\t\tGUARDIAN NAME\t\tGWA");
            System.out.println("  " + "===============================================================================================================================================");

            for (int i = tab; i < tab+10; i++) {
                System.out.println("[" + (i+1) + "] " + studentList.get(i).studentID + "\t" + studentList.get(i).lastName + "\r\t\t\t\t" + studentList.get(i).firstName + "\r\t\t\t\t\t\t\t" + studentList.get(i).birthday + "\r\t\t\t\t\t\t\t\t\t\t" + studentList.get(i).address + "\r\t\t\t\t\t\t\t\t\t\t\t\t\t" + studentList.get(i).guardian + "\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\b" + String.format("%.2f", studentList.get(i).gwa));
                if (i == studentList.size()-1) break;
            }
            System.out.println("  " + "===============================================================================================================================================");
            if (tab > 0) {
                System.out.print("[BACK]");
            }
            if ((tab+9) < studentList.size()) {
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t[NEXT]");
            }
            System.err.println("\n" + errorMessage);
            System.out.print("Enter Index Number of Student to view Grades. [BACK/NEXT] to navigate the table. [X] to go back.");
            System.out.print("\nInput: "); choice = Scan.caro.next().toUpperCase();

            try {
                
                if ((Integer.parseInt(choice)-1) >= 0 && (Integer.parseInt(choice)-1) <= studentList.size()) {
                    viewGrades(studentList, (Integer.parseInt(choice)-1));
                    errorMessage = "";
                } else {
                    errorMessage = "ERROR: Index number does not exist.";
                }
            } catch (Exception e) {
                if (choice.equals("NEXT") && ((tab+9) < studentList.size())) {
                    tab += 9;
                    errorMessage = "";
                } else if (choice.equals("BACK") && (tab > 0)) {
                    tab -= 9;
                    errorMessage = "";
                } else if (choice.equals("X")) {
                    break;
                }
                else {
                    errorMessage = "ERROR: Invalid Choice";
                }
            }
        }
    }

    static void viewGrades(ArrayList<studentDatabase> studentList, int studentIndex) {
            clearConsole.main(); displayLogo(); gradeReport(studentList.get(studentIndex).firstName + " " + studentList.get(studentIndex).lastName);
            System.out.println("COURSE NAME\t\t\tGRADE\n=======================================");
            for (int i = 0; i < 8; i++) {
                System.out.printf("%s\r\t\t\t\t  %d\n", CourseDatabase.getCourseList().get(i).shortName, studentList.get(studentIndex).courseGrade[i]);
            }
            System.out.printf("General Weighted Average\t%.2f\n\n", studentList.get(studentIndex).gwa);
            
            System.out.print("Press any key to return: "); Scan.caro.next();
    }
    

    public static void main(String[] args) {
    String errorMesage = "";

        while (true) {
            clearConsole.main();
            displayLogo();
            displayMenu();
            System.out.println(errorMesage);
            System.out.print("\n\t\t\b\bEnter your choice: ");
            
            switch (Scan.caro.next()) {
                case "1":
                    subMenu1();
                    break;

                case "2":
                    printDatabase(studentDatabase.getStudentList());
                    break;

                case "0":
                    clearConsole.main(); System.out.println("Program ended.");
                    System.exit(0);

                default:
                    errorMesage = "ERROR: Invalid input. Please enter a valid option. [0-2]";
                    break;
            }
        }
    }
}