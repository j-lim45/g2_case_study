import java.time.LocalDate; import java.time.DateTimeException;

public class setUserAttribute {
    static String invalidCharacters = ";\\\"\',./<>?|`~1234567890!@#$%^&*()_+-=[]{}";

    int setStudentID() {
        int studentID = 0; String errorMessage = "";
        while (true) {
            clearConsole.main(); Menu.displayLogo(); Menu.menuTab("|                 Enter ID Number:                   |\n|(ID must be 8 characters long and starts with '209')|", errorMessage);
            
            try {
                System.out.print("Enter ID: "); studentID = Scan.caro.nextInt();
            } catch (Exception e) {
                errorMessage = "ERROR: ID Number is not a valid input."; Scan.caro.next();
            }
            if      (String.valueOf(studentID).length() != 8)               errorMessage = "ERROR: ID Number must be 8 numbers long.";
            else if (!String.valueOf(studentID).startsWith("209"))   errorMessage = "ERROR: ID Number must start with \"209\".";
            else                                                            return studentID;
        }
    }

    String setLastName() {
        String lastName = ""; String errorMessage = ""; boolean invalid = true;
        Scan.caro.nextLine();
        while (invalid) {
            clearConsole.main(); Menu.displayLogo(); Menu.menuTab("|                 Enter Last Name:                   |", errorMessage);

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
        return lastName;
    }

    String setFirstName() {
        String firstName = ""; String errorMessage = ""; boolean invalid = true;
        Scan.caro.nextLine();
        while (invalid) {
            clearConsole.main(); Menu.displayLogo(); Menu.menuTab("|                 Enter First Name:                  |", errorMessage);

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
        return firstName;
    }

    LocalDate setBirthday() {
        int[] birthday = new int[3]; String errorMessage = "";

        while (true) {
            try {
                clearConsole.main(); Menu.displayLogo(); Menu.menuTab("|          Enter Year of Birth (e.g '1986')          |", errorMessage);
                System.out.print("Input Year: "); birthday[0] = Scan.caro.nextInt();
                errorMessage = "";

                clearConsole.main(); Menu.displayLogo(); Menu.menuTab("|       Enter Month of Birth (e.g '5' for May)       |", errorMessage);
                System.out.print("Input Month of Birth: "); birthday[1] = Scan.caro.nextInt();
                errorMessage = "";

                clearConsole.main(); Menu.displayLogo(); Menu.menuTab("|     Enter Day of Birth (e.g '15' for May 15th)     |", errorMessage);
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
        return LocalDate.of(birthday[0], birthday[1], birthday[2]);
    }

    String setAddress() {
        String address = ""; boolean invalid = true; String errorMessage = "";
        Scan.caro.nextLine();
        while (invalid) {
            clearConsole.main(); Menu.displayLogo(); Menu.menuTab("|                 Enter First Name:                  |", errorMessage);

            System.out.print("Input Address: ");
            address = Scan.caro.nextLine().toUpperCase();

            invalid = false;
            for (int i = 0; i < address.length(); i++) {
                if (address.charAt(i) == ';') {
                    errorMessage = "ERROR: Input contains illegal character.";
                    invalid = true;
                    break;
                }
            }
        }
        return address;
    }

    String setGuardian() {
        String guardian = ""; String errorMessage = ""; boolean invalid = true;
        Scan.caro.nextLine();
        while (invalid) {
            clearConsole.main(); Menu.displayLogo(); Menu.menuTab("|     Enter Guardian Name (e.g 'JUAN DELA CRUZ')     |", errorMessage);

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
        return guardian;
    }

    int setCourseGrade(int i) {
        String errorMessage = ""; int grade;
        while (true) {
            clearConsole.main(); Menu.displayLogo(); Menu.menuTab("|\t\t    " + CourseDatabase.getCourseList().get(i).shortName + "\r\t\t\t\t\t\t", errorMessage);
            
            try {
                System.out.print( "Input Grade [0-100]: "); grade = Scan.caro.nextInt();
            } catch (Exception e) {
                errorMessage = "ERROR: Input is not valid";
                continue;
            }

            if (grade <= 100 && grade >= 0) {
                return grade;
            }
            errorMessage = "Grade is outside range.";
        }
    }
}