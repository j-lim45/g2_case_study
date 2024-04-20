import java.util.ArrayList;
import java.time.LocalDate; import java.time.DateTimeException;

class Menu {
    
    static void userMenu() {
        String errorMessage = ""; String choice;

        while (true) {
            clearConsole.main(); Display.logo(); Display.userMenuScreen();  
            System.out.println(errorMessage);
            
            System.out.print("\n\t\t\b\bEnter your choice: "); choice = Scan.caro.next();

            if (choice.equals("1")) {
                addUserInput();
                errorMessage = "";

            } else if (choice.equals("2")) {
                try {
                editUser(studentDatabase.getStudentList());
                } catch (IndexOutOfBoundsException ie) {
                    errorMessage = "ERROR: No user found.";
                }

            } else if (choice.equals("3")) {
                if (studentDatabase.getStudentList().size() > 0) {
                    deleteSubMenu();
                } else errorMessage = "ERROR: No user to delete.";

            } else if (choice.equals("0")) {
                break;

            } else errorMessage = "ERROR: Invalid input. Please enter a valid option. [0-2]";
        }
    }

    static void addUserInput() {
        int studentID = 0; String lastName = ""; String firstName = ""; String address = ""; String guardian = ""    ; int[] birthday = new int[3]; double gwa = 0; int[] grades = new int[8];
        String invalidCharacters = ";\\\"\',./<>?|`~1234567890!@#$%^&*()_+-=[]{}";
        String errorMessage = "";

        // ID NUMBER
        while (true) {
            clearConsole.main(); Display.logo(); Display.addUserTab("|                 Enter ID Number:                   |\n|(ID must be 8 characters long and starts with '209')|", errorMessage);
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
            clearConsole.main(); Display.logo(); Display.addUserTab("|                 Enter Last Name:                   |", errorMessage);

            System.out.print("Input Last Name: "); lastName = Scan.caro.nextLine().toUpperCase();

            invalid = false;
            for (int i = 0; i < lastName.length(); i++) {
                for (int j = 0; j < invalidCharacters.length(); j++) {
                    if (lastName.charAt(i) == invalidCharacters.charAt(j)) {
                        errorMessage = "ERROR: Input contains illegal characters such as special characters or numbers.";
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
            clearConsole.main(); Display.logo(); Display.addUserTab("|                 Enter First Name:                  |", errorMessage);

                System.out.print("Input First Name: ");
                firstName = Scan.caro.nextLine().toUpperCase();

                invalid = false;
                for (int i = 0; i < firstName.length(); i++) {
                    for (int j = 0; j < invalidCharacters.length(); j++) {
                        if (firstName.charAt(i) == invalidCharacters.charAt(j)) {
                            errorMessage = "ERROR: Input contains illegal characters such as special characters or numbers.";
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
                    clearConsole.main(); Display.logo(); Display.addUserTab("|          Enter Year of Birth (e.g '1986'):         |", errorMessage);
                    System.out.print("Input Year: "); birthday[0] = Scan.caro.nextInt();
                    errorMessage = "";

                    clearConsole.main(); Display.logo(); Display.addUserTab("|       Enter Month of Birth (e.g '5' for May):      |", errorMessage);
                    System.out.print("Input Month of Birth: "); birthday[1] = Scan.caro.nextInt();
                    errorMessage = "";

                    clearConsole.main(); Display.logo(); Display.addUserTab("|     Enter Day of Birth (e.g '15' for May 15th):    |", errorMessage);
                    System.out.print("Input Day of Birth: "); birthday[2] = Scan.caro.nextInt();
                    errorMessage = "";

                    // LocalDate.of(birthday[0], birthday[1], birthday[2]);
                    Scan.caro.nextLine();
                    if (LocalDate.of(birthday[0], birthday[1], birthday[2]).isAfter(LocalDate.now())) {
                        errorMessage = "ERROR: Inputted date is after today.";
                    } else {
                        break;
                    }

                } catch (DateTimeException dte) {
                    errorMessage = "ERROR: Invalid date format. Please try again.";

                } catch (Exception e) {
                    errorMessage = "ERROR: Invalid input. Please input correctly."; Scan.caro.next();

                }
            }
            
        // ADDRESS
        errorMessage = ""; invalid = true;
        while (invalid) {
            clearConsole.main(); Display.logo(); Display.addUserTab("|         Enter Address (e.g 'ANGELES CITY'):        |", errorMessage);

            System.out.print("Input Address: ");
            address = Scan.caro.nextLine().toUpperCase();

            invalid = false;
            for (int i = 0; i < address.length(); i++) {
                if (address.charAt(i) == ';') {
                    errorMessage = "ERROR: Input contains an illegal character ';'.";
                    invalid = true;
                    break;

                }
            }
        }

        // GUARDIAN NAME
        errorMessage = ""; invalid = true;
        while (invalid) {
            clearConsole.main(); Display.logo(); Display.addUserTab("|     Enter Guardian Name (e.g 'JUAN DELA CRUZ'):    |", errorMessage);

            System.out.print("Input Guardian: ");
            guardian = Scan.caro.nextLine().toUpperCase();

            invalid = false;
            for (int i = 0; i < guardian.length(); i++) {
                for (int j = 0; j < invalidCharacters.length(); j++) {
                    if (guardian.charAt(i) == invalidCharacters.charAt(j)) {
                        errorMessage = "ERROR: Input contains illegal characters such as special characters or numbers.";
                        invalid = true;
                        break;

                    }
                }
                if (invalid) break;
            }
        }

        String lineToWrite = String.format("%d;%s;%s;%d;%d;%d;%s;%s;", studentID, lastName, firstName, birthday[0], birthday[1], birthday[2], address, guardian);
        // COURSE GRADES
        errorMessage = ""; String choice;
        while (true) {
            clearConsole.main(); Display.logo(); Display.addUserTab("|        Do you want to input your grades?           |", errorMessage);
            System.out.print("Input [Y/N]: "); choice = Scan.caro.next().toUpperCase();
                if (choice.equals("Y")) {
                    grades = CourseDatabase.inputGrades();
                    // GWA CALCULATION
                    for (int i = 0; i < grades.length; i++) {
                        gwa += grades[i];
                    }
                    gwa /= grades.length;

                    break;
                } else if (choice.equals("N")) {
                    for (int i = 0; i < grades.length; i++) { // sets every course to 0
                        grades[i] = 0;
                    }
                    gwa = 0;
                    break;
                } else errorMessage = "ERROR: Invalid Choice.";
            }

            lineToWrite += gwa;
        for (int i = 0; i < grades.length; i++) {
            lineToWrite += ";" + grades[i];
        }

        studentDatabase.getStudentList().add(new studentDatabase(studentID, lastName, firstName, LocalDate.of(birthday[0], birthday[1], birthday[2]), address, guardian, gwa, grades));
        studentDatabase.writeUserToFile(lineToWrite);

        }

    static int editUserTable(ArrayList<studentDatabase> studentList) {
        int currentTab = 0; String choice; String errorMessage = "";
        while (true) {
            clearConsole.main(); Display.logo(); Display.databaseTableTab();
            System.out.println("  " + "STUDENT ID\tLAST NAME\tFIRST NAME\t\tBIRTHDAY\t\tADDRESS\t\t\tGUARDIAN NAME\t\tGWA");
            System.out.println("  " + "===============================================================================================================================================");

            for (int i = currentTab; i < currentTab+10; i++) {
                System.out.printf("[%d] %d\t%s\r\t\t\t\t%s\r\t\t\t\t\t\t\t%s\r\t\t\t\t\t\t\t\t\t\t%s\r\t\t\t\t\t\t\t\t\t\t\t\t\t%s\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\b%.2f\n",
                (i+1), studentList.get(i).studentID, studentList.get(i).lastName, studentList.get(i).firstName,
                studentList.get(i).birthday, studentList.get(i).address, studentList.get(i).guardian, studentList.get(i).gwa);
                if (i == studentList.size()-1) break;
            }
            System.out.println("  " + "===============================================================================================================================================");
            if (currentTab > 0) {
                System.out.print("[BACK]");
            }
            if ((currentTab+9) < studentList.size()) {
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
                if (choice.equals("NEXT") && ((currentTab+9) < studentList.size())) {
                    currentTab += 9;
                    errorMessage = "";
                } else if (choice.equals("BACK") && (currentTab > 0)) {
                    currentTab -= 9;
                    errorMessage = "";
                } else if (choice.equals("X")) {
                    return -1;
                }
                else {
                    errorMessage = "ERROR: Invalid Choice.";
                }
            }
        }
    }

    static void editUser(ArrayList<studentDatabase> studentList) {
        String choice; String errorMessage = ""; setUserAttribute set = new setUserAttribute();
        while (true) {
            
            clearConsole.main(); Display.logo(); Display.editUserTab();
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
                clearConsole.main(); Display.logo(); Display.editUserTab();
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
                    courseGrade[0] = set.setCourseGrade(0); // 2MATHWORLD
                } else if (choice.equals("8")) {
                    courseGrade[1] = set.setCourseGrade(1); // 4FYE2
                } else if (choice.equals("9")) {
                    courseGrade[2] = set.setCourseGrade(2); // 9STS
                } else if (choice.equals("10")) {
                    courseGrade[3] = set.setCourseGrade(3); // 6CFUN
                } else if (choice.equals("11")) {
                    courseGrade[4] = set.setCourseGrade(4); // 6LOGPROG
                } else if (choice.equals("12")) {
                    courseGrade[5] = set.setCourseGrade(5); // THEOLOGY101
                } else if (choice.equals("13")) {
                    courseGrade[6] = set.setCourseGrade(6); // 7TPE1
                } else if (choice.equals("14")) {
                    courseGrade[7] = set.setCourseGrade(7); // CWTS1
                } else if (choice.equals("X")) {
                    break;
                } else if (choice.equals("CONFIRM")) {
                    double gwa = 0; // calculates gwa after confirming grades
                    for (int i = 0; i < CourseDatabase.getCourseList().size(); i++) {
                        gwa += courseGrade[i];
                    }
                    gwa /= CourseDatabase.getCourseList().size();
                    // sets the changed info in the arrayList
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
                    // rewrites the info in the csv file
                    studentDatabase.reWriteFile(studentList);
                    clearConsole.main(); Display.logo(); Display.editUserTab(); System.out.println("Changes succesfully made.");
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

    static void deleteSubMenu() {
        String choice; String errorMessage = "";
        while (true) {
            clearConsole.main(); Display.logo(); Display.deleteUserTab(); Display.deleteMenuTab(); System.err.println(errorMessage);
            System.out.print("Input [0-2]: "); choice = Scan.caro.next();
            if (choice.equals("1")) {
                deleteUserTable(studentDatabase.getStudentList());
            } else if (choice.equals("2")) {
                deleteAll(studentDatabase.getStudentList());
                break;
            } else if (choice.equals("0")) {
                break;
            } else {
                errorMessage = "ERROR: Invalid Choice.";
            }
        }
    }

    static void deleteUserTable(ArrayList<studentDatabase> studentList) {
        int tab = 0; String choice; String errorMessage = "";
        while (true) {
            clearConsole.main(); Display.logo(); Display.databaseTableTab();
            System.out.println("  " + "STUDENT ID\tLAST NAME\tFIRST NAME\t\tBIRTHDAY\t\tADDRESS\t\t\tGUARDIAN NAME\t\tGWA");
            System.out.println("  " + "===============================================================================================================================================");

            for (int i = tab; i < tab+10; i++) {
                System.out.printf("[%d] %d\t%s\r\t\t\t\t%s\r\t\t\t\t\t\t\t%s\r\t\t\t\t\t\t\t\t\t\t%s\r\t\t\t\t\t\t\t\t\t\t\t\t\t%s\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\b%.2f\n",
                (i+1), studentList.get(i).studentID, studentList.get(i).lastName, studentList.get(i).firstName,
                studentList.get(i).birthday, studentList.get(i).address, studentList.get(i).guardian, studentList.get(i).gwa);
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
            System.out.print("Enter Index Number of Student to Delete. [BACK/NEXT] to navigate the table. [X] to go back.");
            System.out.print("\nInput: "); choice = Scan.caro.next().toUpperCase();
            try {
                if ((Integer.parseInt(choice)-1) >= 0 && (Integer.parseInt(choice)-1) <= studentList.size()) {
                    while (true) {
                        clearConsole.main(); Display.logo(); 
                        System.out.printf("\nAre you sure you want to delete \"%s %s\" from the database?\n\n", studentList.get(Integer.parseInt(choice)-1).firstName, studentList.get(Integer.parseInt(choice)-1).lastName);
                        System.err.println(errorMessage);
                        System.out.print("Input [Y/N]: "); String confirm = Scan.caro.next().toUpperCase();
                        if (confirm.equals("Y")) {
                            studentList.remove(Integer.parseInt(choice)-1);
                            studentDatabase.reWriteFile(studentList);

                            clearConsole.main(); Display.logo(); Display.deleteUserTab(); System.out.println("User succesfully deleted.");
                            System.out.print("\nInput any key to continue: "); Scan.caro.next();
                            break;
                        } else if (confirm.equals("N")) {
                            break;
                        } else {
                            errorMessage = "ERROR: Invalid Choice.";
                        }
                    }
                    break;
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
                    errorMessage = "ERROR: Invalid Choice.";
                }
            }
        }
    }

    static void deleteAll(ArrayList<studentDatabase> studentList) {
        String errorMessage = ""; String choice;
        while (true) {
            clearConsole.main(); Display.logo(); Display.deleteUserTab();
            System.out.println("Are you sure you want to delete all users? This action is irreversible.\n");
            System.out.println(errorMessage);
            System.out.print("Input [Y/N]: "); choice = Scan.caro.next().toUpperCase();
            if (choice.equals("Y")) {
                studentList.clear();
                studentDatabase.reWriteFile(studentList);

                clearConsole.main(); Display.logo(); Display.deleteUserTab();
                System.out.println("Database successfully cleared. Input any key to continue: "); Scan.caro.next();
                break;

            } else if (choice.equals("N")) {
                break;
            } else errorMessage = "ERROR: Invalid Choice.";
        }
    }

    static void viewDatabaseSubMenu() {
        String errorMessage = ""; String choice;
        while (true) {
            clearConsole.main(); Display.logo(); Display.databaseMenuScreen();
            System.err.println(errorMessage);
   
            System.out.print("\t\tEnter Choice [0-6]: "); choice = Scan.caro.next();

            if (choice.equals("1")) {
                printDatabase(studentDatabase.getStudentList());
            } else if (choice.equals("2")) {
                presidentListTable(studentDatabase.getStudentList());
            } else if (choice.equals("3")) {
                deansListTable(studentDatabase.getStudentList());
            } else if (choice.equals("4")) {
                passersList(studentDatabase.getStudentList());
            } else if (choice.equals("5")) {
                conditionalList(studentDatabase.getStudentList());
            } else if (choice.equals("0")) {
                break;
            } else errorMessage = "ERROR: Invalid Choice.";
        }
    }

    static void presidentListTable(ArrayList<studentDatabase> studentList) {
        int counter = 1; boolean minimumGrade;
        clearConsole.main(); Display.logo(); Display.PLTableTab();
        System.out.println("  " + "STUDENT ID\tLAST NAME\tFIRST NAME\t2MATHWORLD\t\b\b4FYE2\t\b9STS\t\b6CFUN\t6LOGPROG\t\b\b\b\b\bTHEOLOGY101\t7TPE1\tCWTS1\tGWA");
        System.out.println("  " + "===============================================================================================================================================");
        try {
            for (int i = 0; i < studentList.size(); i++) {

                minimumGrade = true;
                for (int j = 0; j < 8; j++) {
                    if (studentList.get(i).courseGrade[j] < 85) {
                        minimumGrade = false;
                        break;
                    }
                }

                if (studentList.get(i).gwa >= 94 && minimumGrade) {
                System.out.printf("[%d] %s\t%s\r\t\t\t\t%s\r\t\t\t\t\t\t\t\b\b\b\b%d\r\t\t\t\t\t\t\t\t\b%d\r\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t\t   %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\b%.2f\n", 
                counter, studentList.get(i).studentID, studentList.get(i).lastName, studentList.get(i).firstName, 
                studentList.get(i).courseGrade[0], studentList.get(i).courseGrade[1], studentList.get(i).courseGrade[2],
                studentList.get(i).courseGrade[3], studentList.get(i).courseGrade[4], studentList.get(i).courseGrade[5],
                studentList.get(i).courseGrade[6], studentList.get(i).courseGrade[7], studentList.get(i).gwa);
                counter++;
                }
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("\t\t\t\t\t\t\t\t\tEMPTY DATABASE");
        }
        System.out.println("  " + "===============================================================================================================================================");
        System.out.println("Requirements: A General Weighted Average of at least 94.00, and a minimum course grade of 85.");
        System.out.print("\nInput any key to return: "); Scan.caro.next();
    }

    static void deansListTable(ArrayList<studentDatabase> studentList) {
        int counter = 1; boolean minimumGrade;
        clearConsole.main(); Display.logo(); Display.DLTableTab();
        System.out.println("  " + "STUDENT ID\tLAST NAME\tFIRST NAME\t2MATHWORLD\t\b\b4FYE2\t\b9STS\t\b6CFUN\t6LOGPROG\t\b\b\b\b\bTHEOLOGY101\t7TPE1\tCWTS1\tGWA");
        System.out.println("  " + "===============================================================================================================================================");
        try {
            for (int i = 0; i < studentList.size(); i++) {

                minimumGrade = true;
                for (int j = 0; j < 8; j++) {
                    if (studentList.get(i).courseGrade[j] < 85) {
                        minimumGrade = false;
                        break;
                    }
                }

                if (studentList.get(i).gwa >= 88 && studentList.get(i).gwa <= 93.99 && minimumGrade) {
                System.out.printf("[%d] %s\t%s\r\t\t\t\t%s\r\t\t\t\t\t\t\t\b\b\b\b%d\r\t\t\t\t\t\t\t\t\b%d\r\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t\t   %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\b%.2f\n", 
                counter, studentList.get(i).studentID, studentList.get(i).lastName, studentList.get(i).firstName, 
                studentList.get(i).courseGrade[0], studentList.get(i).courseGrade[1], studentList.get(i).courseGrade[2],
                studentList.get(i).courseGrade[3], studentList.get(i).courseGrade[4], studentList.get(i).courseGrade[5],
                studentList.get(i).courseGrade[6], studentList.get(i).courseGrade[7], studentList.get(i).gwa);
                counter++;
                }
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("\t\t\t\t\t\t\t\t\tEMPTY DATABASE");
        }
        System.out.println("  " + "===============================================================================================================================================");
        System.out.println("Requirements: A General Weighted Average from 88.00 to 93.99, and a minimum course grade of 85.");
        System.out.print("\nInput any key to return: "); Scan.caro.next();
    }

    static void passersList(ArrayList<studentDatabase> studentList) {
        int counter = 1; boolean minimumGrade;
        clearConsole.main(); Display.logo(); Display.passersTab();
        System.out.println("  " + "STUDENT ID\tLAST NAME\tFIRST NAME\t2MATHWORLD\t\b\b4FYE2\t\b9STS\t\b6CFUN\t6LOGPROG\t\b\b\b\b\bTHEOLOGY101\t7TPE1\tCWTS1\tGWA");
        System.out.println("  " + "===============================================================================================================================================");
        try {
            for (int i = 0; i < studentList.size(); i++) {

                minimumGrade = true;
                for (int j = 0; j < 8; j++) {
                    if (studentList.get(i).courseGrade[j] < 75) {
                        minimumGrade = false;
                        break;
                    }
                }

                if (studentList.get(i).gwa >= 80 && minimumGrade) {
                System.out.printf("[%d] %s\t%s\r\t\t\t\t%s\r\t\t\t\t\t\t\t\b\b\b\b%d\r\t\t\t\t\t\t\t\t\b%d\r\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t\t   %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\b%.2f\n", 
                counter, studentList.get(i).studentID, studentList.get(i).lastName, studentList.get(i).firstName, 
                studentList.get(i).courseGrade[0], studentList.get(i).courseGrade[1], studentList.get(i).courseGrade[2],
                studentList.get(i).courseGrade[3], studentList.get(i).courseGrade[4], studentList.get(i).courseGrade[5],
                studentList.get(i).courseGrade[6], studentList.get(i).courseGrade[7], studentList.get(i).gwa);
                counter++;
                }
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("\t\t\t\t\t\t\t\t\tEMPTY DATABASE");
        }
        System.out.println("  " + "===============================================================================================================================================");
        System.out.println("Requirements: A General Weighted Average of at least 80.00, and a minimum course grade of 75.");
        System.out.print("\nInput any key to return: "); Scan.caro.next();
    }

    static void conditionalList(ArrayList<studentDatabase> studentList) {
        int counter = 1; boolean failedCourse;
        clearConsole.main(); Display.logo(); Display.conditionalsTab();
        System.out.println("  " + "STUDENT ID\tLAST NAME\tFIRST NAME\t2MATHWORLD\t\b\b4FYE2\t\b9STS\t\b6CFUN\t6LOGPROG\t\b\b\b\b\bTHEOLOGY101\t7TPE1\tCWTS1\tGWA");
        System.out.println("  " + "===============================================================================================================================================");
        try {
            for (int i = 0; i < studentList.size(); i++) {

                failedCourse = false;
                for (int j = 0; j < 8; j++) {
                    if (studentList.get(i).courseGrade[j] < 75) {
                        failedCourse = true;
                        break;
                    }
                }

                if (studentList.get(i).gwa < 80 || failedCourse) {
                System.out.printf("[%d] %s\t%s\r\t\t\t\t%s\r\t\t\t\t\t\t\t\b\b\b\b%d\r\t\t\t\t\t\t\t\t\b%d\r\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t\t   %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t%d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %d\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\b%.2f\n", 
                counter, studentList.get(i).studentID, studentList.get(i).lastName, studentList.get(i).firstName, 
                studentList.get(i).courseGrade[0], studentList.get(i).courseGrade[1], studentList.get(i).courseGrade[2],
                studentList.get(i).courseGrade[3], studentList.get(i).courseGrade[4], studentList.get(i).courseGrade[5],
                studentList.get(i).courseGrade[6], studentList.get(i).courseGrade[7], studentList.get(i).gwa);
                counter++;
                }
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("\t\t\t\t\t\t\t\t\tEMPTY DATABASE");
        }
        System.out.println("  " + "===============================================================================================================================================");
        System.out.println("Requirements: A General Weighted Average lower than 80.00 or at least one course grade lower than 75.");
        
        System.out.print("\nInput any key to return: "); Scan.caro.next();
    }


    static void printDatabase(ArrayList<studentDatabase> studentList) {
        int currentTab = 0; String choice; String errorMessage = "";
        while (true) {
            clearConsole.main(); Display.logo(); Display.databaseTableTab();
            System.out.println("  " + "STUDENT ID\tLAST NAME\tFIRST NAME\t\tBIRTHDAY\t\tADDRESS\t\t\tGUARDIAN NAME\t\tGWA");
            System.out.println("  " + "===============================================================================================================================================");
            try {
                for (int i = currentTab; i < currentTab+10; i++) { // prints students by 10 in each tab
                    System.out.printf("[%d] %d\t%s\r\t\t\t\t%s\r\t\t\t\t\t\t\t%s\r\t\t\t\t\t\t\t\t\t\t%s\r\t\t\t\t\t\t\t\t\t\t\t\t\t%s\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\b%.2f\n",
                    (i+1), studentList.get(i).studentID, studentList.get(i).lastName, studentList.get(i).firstName,
                    studentList.get(i).birthday, studentList.get(i).address, studentList.get(i).guardian, studentList.get(i).gwa);
                    if (i == studentList.size()-1) break;
                }
            } catch (IndexOutOfBoundsException ie) {
                System.out.println("\t\t\t\t\t\t\t\t\tEMPTY DATABASE");
            }
            System.out.println("  " + "===============================================================================================================================================");
            if (currentTab > 0) { // if current tab is on the first 10 students, [BACK] will not be printed
                System.out.print("[BACK]");
            }
            if ((currentTab+9) < studentList.size()) { // if current tab is on the last 10 students, [NEXT] will not be printed
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t[NEXT]");
            }
            System.err.println("\n" + errorMessage);
            System.out.print("\nEnter Index Number of Student to view Grades. [BACK/NEXT] to navigate the table. [X] to go back.");
            System.out.print("\nInput: "); choice = Scan.caro.next().toUpperCase();

            try {
                if ((Integer.parseInt(choice)-1) >= 0 && (Integer.parseInt(choice)-1) <= studentList.size()) {
                    viewGrades(studentList, (Integer.parseInt(choice)-1));
                    errorMessage = "";
                } else {
                    errorMessage = "ERROR: Index number does not exist.";
                }

            } catch (Exception e) {
                if (choice.equals("NEXT") && ((currentTab+9) < studentList.size())) {
                    currentTab += 9;
                    errorMessage = "";
                } else if (choice.equals("BACK") && (currentTab > 0)) {
                    currentTab -= 9;
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
            clearConsole.main(); Display.logo(); Display.gradeReportTab(studentList.get(studentIndex).firstName + " " + studentList.get(studentIndex).lastName);
            System.out.println("COURSE NAME\t\t\tGRADE\n=======================================");
            for (int i = 0; i < 8; i++) {
                System.out.printf("%s\r\t\t\t\t  %d\n", CourseDatabase.getCourseList().get(i).shortName, studentList.get(studentIndex).courseGrade[i]);
            }
            System.out.printf("General Weighted Average\t%.2f\n\n", studentList.get(studentIndex).gwa);
            
            System.out.print("Press any key to return: "); Scan.caro.next();
    }
}