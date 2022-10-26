import java.util.Scanner;
import java.lang.Math;

public class GradeCalculator {

    private String category;
    private double current;
    private double percent;
    private double desired;
    private double test;

    private double percent_test;
    private double current_test;
    private int points_test;
    private int points_final;

    public double calculate() {
        this.enterCat();

        if (category.equals("separate")) {
            this.enterVals();
            test = (desired - (current * (1-percent/100))) / (percent/100);
        }

        else if (category.equals("tests")) {
            this.enterPoints();
            percent_test /= 100;
            int current_points = (int)current - (int)(percent_test) * points_test;
            test = ((desired - ((1-percent_test)*current_points)/percent_test) - points_test);
        }

        return test;
    }

    private void enterCat() {
        while (true) {
            Scanner dd = new Scanner(System.in);
            System.out.print("Enter final category (separate/tests): ");
            try {
                category = dd.nextLine();
                System.out.println(category);
                break;

            } catch (Exception e) { 
                System.out.println("Not a string, " + e);
            }
            dd.close();
        }
    }

    private void enterVals() {
        while (true) {
            Scanner dd2 = new Scanner(System.in);
            try {
                System.out.print("Current grade: ");
                current = dd2.nextDouble();
                System.out.println(current);

                System.out.print("Percentage of grade that is final: ");
                percent = dd2.nextDouble();
                System.out.println(percent);

                System.out.print("Desired grade: ");
                desired = dd2.nextDouble();
                System.out.println(desired);

                break;
            } catch (Exception e) { 
                System.out.println(current + "not a double, " + e);
            }
            dd2.close();
        }
    }

    private void enterPoints() {
        while (true) {
            Scanner dd3 = new Scanner(System.in);
            try {
                System.out.print("Current grade: ");
                current = dd3.nextDouble();
                System.out.println(current);

                System.out.print("Percentage of grade that is tests: ");
                percent = dd3.nextDouble();
                System.out.println(percent_test);
                
                System.out.print("Current percent in tests: ");
                current_test = dd3.nextDouble();
                System.out.println(current_test);
                
                System.out.print("Current amount of points in tests: ");
                points_test = dd3.nextInt();
                System.out.println(points_test);

                System.out.print("Amount of points in final: ");
                points_final = dd3.nextInt();
                System.out.println(points_final);

                System.out.print("Desired grade: ");
                desired = dd3.nextDouble();
                System.out.println(desired);

                break;
            } catch (Exception e) { // catch non-numerical input
                System.out.println(current + "not a double, " + e);
            }
            dd3.close();
        }
    }

    public static void main(String[] args) {    // main method
        GradeCalculator calc = new GradeCalculator();
        System.out.println("You need a " + String.format("%.2f", calc.calculate()) + " on the test");
    }
}

GradeCalculator.main(null);
