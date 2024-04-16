class Main {
    public static void main(String[] args) {
        String errorMesage = "";
    
        while (true) {
            clearConsole.main(); Display.logo(); Display.mainMenuScreen();
            System.out.println(errorMesage);

            System.out.print("\n\t\t\b\bEnter your choice: ");
            
            switch (Scan.caro.next()) {
                case "1":
                    Menu.userMenu();
                    break;

                case "2":
                    Menu.viewDatabaseSubMenu();
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
