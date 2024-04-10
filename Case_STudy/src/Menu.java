import java.util.Scanner;

class Menu {
    static Scanner input = new Scanner(System.in);

    static void subMenu1(String choice) {
        clearConsole.main();
        System.out.print("\n[1]  Add\n[2]  Edit\n[3]  Delete User\n");
        System.out.print("Enter your choice: "); choice = input.next();
    }

    static void displayLogo() {
        System.out.println(" ____                                                   ");
        System.out.println("/\\  _`\\                                                 ");
        System.out.println("\\ \\ \\_\\ \\     __      ___ ___   _____   __  __    ____  ");
        System.out.println(" \\ \\  _\\/   /'__`\\  /' __` __`\\/\\ '__`\\/\\ \\/\\ \\  /',__\\ ");
        System.out.println("  \\ \\ \\L\\ \\/\\ \\L\\.\\_/\\ \\/\\ \\/\\ \\ \\ \\L\\ \\ \\ \\_\\ \\/\\__, `\\");
        System.out.println("   \\ \\____/\\ \\__/\\_\\ \\_\\ \\_\\ \\_\\ \\ ,__/\\ \\____/\\/\\____/");
        System.out.println("    \\/___/  \\/__/\\/_/\\/_/\\/_/\\/_/\\ \\ \\/  \\/___/  \\/___/ ");
        System.out.println("                                  \\ \\_\\                 ");
        System.out.println("                                   \\/_/                 ");
    }

    public static void main(String[] args) {

        String choice; String errorMesage = "";

        while (true) {
            clearConsole.main();
            displayLogo();
            System.out.println(errorMesage);
            System.out.println("\n[1]  Add/Edit/Delete User\n[2]  View Database \n[3]  Exit");
            System.out.print("Enter your choice:");
            choice = input.next();
            
            switch (choice) {
                case "1":
                    subMenu1(choice);
                    break;

                case "2":
                    System.out.println("Hi");
                    break;

                case "3":
                    input.close();
                    System.exit(0);
                    break;

                default:
                    errorMesage = "Invalid choice. Please enter a valid option.";
                    break;
            }
        }
    }
}