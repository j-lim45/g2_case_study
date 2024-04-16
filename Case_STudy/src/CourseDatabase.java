import java.util.ArrayList;

public class CourseDatabase {
    String shortName;

    CourseDatabase(String sn) {
        shortName = sn;
    }

    static ArrayList<CourseDatabase> getCourseList() {
        ArrayList<CourseDatabase> courseList = new ArrayList<CourseDatabase>();

        courseList.add(new CourseDatabase("2MATHWORLD"));
        courseList.add(new CourseDatabase("4FYE2"));
        courseList.add(new CourseDatabase("9STS"));
        courseList.add(new CourseDatabase("6CFUN"));
        courseList.add(new CourseDatabase("6LOGPROG"));
        courseList.add(new CourseDatabase("THEOLOGY101"));
        courseList.add(new CourseDatabase("7TPE1"));
        courseList.add(new CourseDatabase("CWTS1"));

        return courseList;
    }

    static int[] inputGrades() {
        int[] grades = new int[8]; int i = 0; String choice; String errorMessage = "";

        while (true) {
            i = 0;
            while (i < grades.length) {
                clearConsole.main(); Display.logo(); Display.addUserTab("|\t\t    " + getCourseList().get(i).shortName + "\r\t\t\t\t\t\t", errorMessage);
                try {
                    System.out.print( "Input Grade [0-100]: "); grades[i] = Scan.caro.nextInt();
                } catch (Exception e) {
                    errorMessage = "ERROR: Input is not valid.";
                    Scan.caro.next();
                    continue;
                }

                if (grades[i] <= 100 & grades[i] >= 0) {
                    i++;
                    errorMessage = "";
                    continue;
                }
                errorMessage = "ERROR: Grade is outside range.";
            }

            clearConsole.main(); Display.logo(); Display.addUserTab("|                 CONFIRM GRADES                     |", errorMessage);
            for (int j = 0; j < getCourseList().size(); j++) {
                System.out.println(getCourseList().get(j).shortName + ": " + grades[j]);
            }

            System.out.print("\nConfirm Grades [Y/N]: "); choice = Scan.caro.next().toUpperCase();
            while (true) {
                if (choice.equals("Y")) {
                    return grades;
                } else if (choice.equals("N")) {
                    break;
                }
            }
            continue;
        }
    }

}