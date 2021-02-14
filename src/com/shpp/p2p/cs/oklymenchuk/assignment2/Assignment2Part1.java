package com.shpp.p2p.cs.oklymenchuk.assignment2;

import com.shpp.cs.a.console.TextProgram;

import java.util.Scanner;

/**
 * Solving a quadratic equation.
 */
public class Assignment2Part1 extends TextProgram {

    // надо решать через МАПы!!! Это ФСЁ БАБУЙНЯ!!!

    private final static String SIGN_MINUS = "minus";
    private final static String SIGN_PLUS = "plus";
    private final static String COEFFICIENT_A = "a";
    private final static String COEFFICIENT_B = "b";
    private final static String COEFFICIENT_C = "c";

    /**
     * Main method.
     */
    public void run() {

        double a = inputCoefficient(COEFFICIENT_A);
        double b = inputCoefficient(COEFFICIENT_B);
        double c = inputCoefficient(COEFFICIENT_C);

        // for debug
        // System.out.println(a + " " + b + " " + c);

        // check a == 0
        if (a == 0) {
            System.out.println("It`s not a quadratic equation");
            System.exit(-1);
        }

        // find the discriminant
        double theDiscriminant = (b * b) - (4 * a * c);

        // for debug
        //System.out.println("Discriminant is " + theDiscriminant);

        if (theDiscriminant < 0) {
            System.out.println("There are no real roots");
        }

        if (theDiscriminant == 0) {
            System.out.println("There is one root: " + theRoot(theDiscriminant, a, b, SIGN_MINUS));
        }

        if (theDiscriminant > 0) {
            System.out.println("There are two roots: " + theRoot(theDiscriminant, a, b, SIGN_MINUS)
                    + " and " +
                    theRoot(theDiscriminant, a, b, SIGN_PLUS));
        }
    }

    /**
     * Return a root of the quadratic equation
     * @param discriminant
     * @param a
     * @param b
     * @param sign
     * @return
     */
    private double theRoot(double discriminant, double a, double b, String sign) {
        if (sign.equals(SIGN_MINUS)) {
            return (-b - Math.sqrt(discriminant)) / (2 * a);
        } else {
            return (-b + Math.sqrt(discriminant)) / (2 * a);
        }
    }

    private double inputCoefficient(String coefficient){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Please enter " + coefficient + ": ");
            if(scanner.hasNextDouble()){
                return scanner.nextDouble();
            } else {
                System.out.println("Invalid format! Please, input the coefficient again!");
                scanner.nextLine();
            }
        }
    }
}