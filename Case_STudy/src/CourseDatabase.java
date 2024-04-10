public class CourseDatabase {
    String fullName; int creditUnits;

    CourseDatabase() {

    }

    CourseDatabase(String n, int u) {
        fullName = n;
        creditUnits = u;
    }

    static CourseDatabase _2MATHWORLD = new CourseDatabase("Mathematics in the Modern World", 3);
    static CourseDatabase _4FYE1 = new CourseDatabase("Big History: Big Bang to the Future", 3);
    static CourseDatabase _9STS = new CourseDatabase("Science, Technology and Society", 3);
    static CourseDatabase _6CFUN = new CourseDatabase("Computing Fundamentals", 3);
    static CourseDatabase _6LOGPROG = new CourseDatabase("Logic Formulation and Introductory Programming", 3);
    static CourseDatabase _THEOLOGY101 = new CourseDatabase("Theological Foundations: Judeo-Christian Tradition and Sacred Scriptures", 3);
    static CourseDatabase _7TPE1 = new CourseDatabase("Physical Activities Toward Health and Fitness 1: Movement Competency Training", 2);
    static CourseDatabase _CWTS1 = new CourseDatabase("Civic Welfare Training Services", 3);

    int[] inputGrades() {
        int[] grades = new int[8];

        while (true) {
            clearConsole.main();
            System.out.println("INPUT GRADES (0-100)");

            while (true) {
                try {
                    System.out.print("2MATHWORLD: "); grades[0] = Scan.caro.nextInt();
                } catch (Exception e) {
                    System.out.println("Input is not valid.");
                }
            }



        }

        return grades;
    }

}