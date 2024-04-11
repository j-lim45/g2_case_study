import java.time.DateTimeException;
import java.time.LocalDate;

class Menu {

    static void subMenu1() {
        clearConsole.main(); displayLogo(); displaySubMenu1();

        String choice;
        System.out.print("\n\t\t\b\bEnter your choice: "); choice = Scan.caro.next();
        switch (choice) {
            case "1":
                addUser();
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
            clearConsole.main(); displayLogo(); addUserTab("|                 Enter ID Number:                   |\n|(ID must be 8 characters long and starts with '209')|", errorMessage);
            try {
                studentID = Scan.caro.nextInt();
            } catch (Exception e) {
                errorMessage = "ERROR: ID Number is not a valid input."; Scan.caro.next();
            }
            if      (String.valueOf(studentID).length() != 8)               errorMessage = "ERROR: ID Number must be 8 numbers long.";
            else if (!String.valueOf(studentID).startsWith("209"))   errorMessage = "ERROR: ID Number must start with \"209\".";
            else                                                            break;
        }

        // LAST NAME
        errorMessage = ""; boolean invalid = true;
        while (invalid) {
            clearConsole.main(); displayLogo(); addUserTab("|                 Enter Last Name:                   |", errorMessage);

            System.out.print("Input Last Name: "); Scan.caro.nextLine();
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
            clearConsole.main(); displayLogo(); addUserTab("|                 Enter First Name:                  |", errorMessage);

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
        while (true) {
                try {
                    clearConsole.main(); displayLogo(); addUserTab("|          Enter Year of Birth (e.g '1986')          |", errorMessage);
                    System.out.print("Input Year: "); birthday[0] = Scan.caro.nextInt();
                    clearConsole.main(); displayLogo(); addUserTab("|       Enter Month of Birth (e.g '5' for May)       |", errorMessage);
                    System.out.print("Input Month of Birth: "); birthday[1] = Scan.caro.nextInt();
                    clearConsole.main(); displayLogo(); addUserTab("|     Enter Day of Birth (e.g '15' for May 15th)     |", errorMessage);
                    System.out.print("Input Day of Birth: "); birthday[2] = Scan.caro.nextInt();
                    LocalDate.of(birthday[0], birthday[1], birthday[2]);
                    break;
                } catch (DateTimeException dte) {
                    errorMessage = "Invalid date format. Please try again.";
                } catch (Exception e) {
                    errorMessage = "Invalid Input. Please input correctly."; Scan.caro.next();
                }
            }

        // ADDRESS
        while (true) {
            clearConsole.main(); displayLogo(); addUserTab("| Enter City Address (e.g 'Municipality of Angeles') |", errorMessage);
            System.out.print("Input Address: "); Scan.caro.nextLine();
            address = Scan.caro.nextLine().toUpperCase();
            break;
        }

        // GUARDIAN NAME
        errorMessage = ""; invalid = true;
        while (invalid) {
            clearConsole.main(); displayLogo(); addUserTab("|     Enter Guardian Name (e.g 'JUAN DELA CRUZ')     |", errorMessage);

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
            clearConsole.main(); displayLogo(); addUserTab("|        Do you want to input your grades?           |", errorMessage);
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

        studentDatabase.getStudentList().add(new studentDatabase(studentID, lastName, firstName, LocalDate.of(birthday[0], birthday[1], birthday[2]), address, guardian, gwa, grades));
        studentDatabase.writeUserToFile(lineToWrite);

        }
    

    static void addUserTab(String fieldPrompt, String errorMessage) {
        System.out.println("|                    ADD USER                        |");
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println(fieldPrompt);
        System.out.println("└────────────────────────────────────────────────────┘");
        System.err.println(errorMessage);
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
                    System.out.println("Hi");
                    break;

                case "0":
                    System.exit(0);

                default:
                    errorMesage = "ERROR: Invalid input. Please enter a valid option. [0-2]";
                    break;
            }
        }
    }
}