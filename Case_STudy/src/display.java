class Display {
    static void logo() {
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

    static void mainMenuScreen() {
        System.out.println("|                     MAIN MENU                      |");
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                                                    |");
        System.out.println("|             [1] Add/Edit/Delete User               |");
        System.out.println("|             [2] View Database                      |");
        System.out.println("|             [0] EXIT                               |");
        System.out.println("|                                                    |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void userMenuScreen() {
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

    static void addUserTab(String fieldPrompt, String errorMessage) {
        System.out.println("|                    ADD USER                        |");
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println(fieldPrompt);
        System.out.println("└────────────────────────────────────────────────────┘");
        System.err.println(errorMessage);
    }
    
    static void editUserTab() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                     EDIT USER                      |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    
    static void deleteUserTab() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                    DELETE USER                     |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void deleteMenuTab() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                                                    |");
        System.out.println("|                [1] Delete User                     |");
        System.out.println("|                [2] Delete All Users                |");
        System.out.println("|                [0] Exit                            |");
        System.out.println("|                                                    |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }
    
    static void databaseMenuScreen() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                                                    |");
        System.out.println("|             [1] View   All    Students             |");
        System.out.println("|             [2] View President Listers             |");
        System.out.println("|             [3] View   Dean's  Listers             |");
        System.out.println("|             [4] View           Passers             |");
        System.out.println("|             [5] View      Conditionals             |");
        System.out.println("|             [6] View  Students    with             |");
        System.out.println("|             with Incomplete Grades (INC)           |");
        System.out.println("|                                                    |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void databaseTableTab() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                   DATABASE TABLE                   |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void PLTableTab() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                PRESIDENT'S LISTERS                 |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void DLTableTab() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                  DEAN'S LISTERS                    |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void passersTab() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                  LIST OF PASSERS                   |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void conditionalsTab() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("|                LIST OF CONDITIONALS                |");
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static void gradeReportTab(String name) {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.printf("|              %s GRADE REPORT\r\t\t\t\t\t\t\t\b\b\b|\n", name);
        System.out.println("└────────────────────────────────────────────────────┘");
    }
}