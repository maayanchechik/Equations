/* Author: Maayan Chechik
 * Date: 10/03/19
 * This program receives 6 integers for the coefficients a11, a12, a21, a22,
 * b1 & b2. The program calculates and returns the solutions of the next system
 * of two linear equations:
 * a11*x1+a12*x2=b1
 * a21*x1+a22*x2=b2
 * If there is a single solution to the equations, the program rounds it to 
 * three decimal digits and prints the solution.
 * If there is more then one solution for the equations, the program prints 
 * "Many solutions". If there are no solutions it prints "No solution".
 */
import java.util.Scanner;

public class Equations 
{
    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in);
        // TODO Auto-generated method stub
        System.out.println("This program solves a system of 2 linear equations");
        
        // receive and define the 6 integers
        System.out.println("Enter the coefficients a11 a12 a21 a22 b1 b2");
        final int a11 = reader.nextInt();
        final int a12 = reader.nextInt();
        final int a21 = reader.nextInt();
        final int a22 = reader.nextInt();
        final int b1 = reader.nextInt();
        final int b2 = reader.nextInt();
        
        // Print equations
        System.out.println("Eq1: " + a11 + "*x1+" + a12 + "*x2=" + b1);
        System.out.println("eq2: "+ a21+ "*x1+" + a22 + "*x2=" + b2);

        // Define veriables
        boolean singleSolution = false;
        boolean infiniteSolution = false;
        double determinant = a11 * a22 - a12 * a21;
        
        // Start chechik whether there is a single solution, infinite solutions or no solutions.
        // If there is a single solution, round it to 3 decimal digits and print it
        if (determinant != 0) {
            double x1 = ((double) (b1 * a22 - b2 * a12) / determinant);
            double x2 = ((double) (b2 * a11 - b1 * a21) / determinant);
            final double MAX = 1000;
            x1 = Math.round(x1 * MAX) / MAX;
            x2 = Math.round(x2 * MAX) / MAX;
            System.out.println("Single solution: (" + x1 + "," + x2 + ")");
            singleSolution = true;
        }

        // Conditions for infinite solutions.
        boolean condition1 = false;
        boolean condition2 = false;
        boolean condition3 = true;
        
        // Check if the first condition applies.
        if (determinant == 0) {
            condition1 = true;
        }
        
        // Check if the second condition applies.
        if ((b2 * a11 - b1 * a21 == 0) && (b1 * a22 - b2 * a12 == 0)) {
            condition2 = true;
        }
        
        // Check if the third condition does not apply. 
        if (b1 != 0 && a11 == 0 && a12 == 0) {
            condition3 = false;
        }
        if (b2 != 0 && a21 == 0 && a22 == 0) {
            condition3 = false;
        }
        
        // If the three conditions for infinite solutions apply,
        // then print accordingly.
        if (condition1 && condition2 && condition3) {
            System.out.println("Many solutions");
            infiniteSolution = true;
        }
        // If there is no single solution and no infinite solution, then
        // there is no solution so print accordingly.
        if (!(singleSolution || infiniteSolution)) {
            System.out.println("No solution");
        }
        
    } //end of method main
} //end of class