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

    static ArrayList<CourseDatabase> courseList = new ArrayList<CourseDatabase>();
    static void addCourse() {
        courseList.add(new CourseDatabase("2MATHWORLD", "Mathematics in the Modern World", 3));
        courseList.add(new CourseDatabase("4FYE2", "Big History: Big Bang to the Future", 3));
        courseList.add(new CourseDatabase("9STS", "Science, Technology and Society", 3));
        courseList.add(new CourseDatabase("6CFUN", "Computing Fundamentals", 3));
        courseList.add(new CourseDatabase("6LOGPROG", "Logic Formulation and Introductory Programming", 3));
        courseList.add(new CourseDatabase("THEOLOGY101", "Theological Foundations: Judeo-Christian Tradition and Sacred Scriptures", 3));
        courseList.add(new CourseDatabase("7TPE1", "Physical Activities Toward Health and Fitness 1: Movement Competency Training", 2));
        courseList.add(new CourseDatabase("CWTS1", "Civic Welfare Training Services", 3));
    }

    // static CourseDatabase _2MATHWORLD = new CourseDatabase("2MATHWORLD", "Mathematics in the Modern World", 3);
    // static CourseDatabase _4FYE1 = new CourseDatabase("4FYE2", "Big History: Big Bang to the Future", 3);
    // static CourseDatabase _9STS = new CourseDatabase("9STS", "Science, Technology and Society", 3);
    // static CourseDatabase _6CFUN = new CourseDatabase("6CFUN", "Computing Fundamentals", 3);
    // static CourseDatabase _6LOGPROG = new CourseDatabase("6LOGPROG", "Logic Formulation and Introductory Programming", 3);
    // static CourseDatabase _THEOLOGY101 = new CourseDatabase("THEOLOGY101", "Theological Foundations: Judeo-Christian Tradition and Sacred Scriptures", 3);
    // static CourseDatabase _7TPE1 = new CourseDatabase("7TPE1", "Physical Activities Toward Health and Fitness 1: Movement Competency Training", 2);
    // static CourseDatabase _CWTS1 = new CourseDatabase("CWTS1", "Civic Welfare Training Services", 3);

    static int[] inputGrades() {
        int[] grades = new int[8]; int i = 0; String choice;

        while (true) {
            clearConsole.main();
            System.out.println("INPUT GRADES (0-100)");
            i = 0;
            while (i < grades.length) {
                try {
                    System.out.print(courseList.get(i).shortName + ": "); grades[i] = Scan.caro.nextInt();
                } catch (Exception e) {
                    System.out.println("Input is not valid.");
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
            for (int j = 0; j < courseList.size(); j++) {
                System.out.println(courseList.get(j).shortName + ": " + grades[j]);
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