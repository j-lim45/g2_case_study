import java.util.ArrayList;

public class CourseDatabase {
    String shortName; String fullName; int creditUnits;

    CourseDatabase() {

    }

    CourseDatabase(String sn, String fn, int u) {
        shortName = sn;
        fullName = fn;
        creditUnits = u;
    }

    static ArrayList<CourseDatabase> getCourseList() {
        ArrayList<CourseDatabase> courseList = new ArrayList<CourseDatabase>();

        courseList.add(new CourseDatabase("2MATHWORLD", "Mathematics in the Modern World", 3));
        courseList.add(new CourseDatabase("4FYE2", "Big History: Big Bang to the Future", 3));
        courseList.add(new CourseDatabase("9STS", "Science, Technology and Society", 3));
        courseList.add(new CourseDatabase("6CFUN", "Computing Fundamentals", 3));
        courseList.add(new CourseDatabase("6LOGPROG", "Logic Formulation and Introductory Programming", 3));
        courseList.add(new CourseDatabase("THEOLOGY101", "Theological Foundations: Judeo-Christian Tradition and Sacred Scriptures", 3));
        courseList.add(new CourseDatabase("7TPE1", "Physical Activities Toward Health and Fitness 1: Movement Competency Training", 2));
        courseList.add(new CourseDatabase("CWTS1", "Civic Welfare Training Services", 3));

        return courseList;
    }

    static int[] inputGrades() {
        int[] grades = new int[8]; int i = 0; String choice;

        while (true) {
            clearConsole.main();
            System.out.print("INPUT GRADES (0-100): \n");
            i = 0;
            while (i < grades.length) {
                try {
                    System.out.print(getCourseList().get(i).shortName + ": "); grades[i] = Scan.caro.nextInt();
                } catch (Exception e) {
                    System.out.println("Input is not valid.");
                    e.printStackTrace();
                    Scan.caro.next();
                    continue;
                }

                if (grades[i] < 100 & grades[i] > 0) {
                    i++;
                    continue;
                }
                System.out.println("Grade is outside range.");
            }

            clearConsole.main();
            System.out.println("CONFIRM GRADES");
            for (int j = 0; j < getCourseList().size(); j++) {
                System.out.println(getCourseList().get(j).shortName + ": " + grades[j]);
            }

            System.out.println("\nConfirm Grades [Y/N]: "); choice = Scan.caro.next().toUpperCase();
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