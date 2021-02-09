package com.shpp.p2p.cs.oklymenchuk.assignment2;

import com.shpp.cs.a.console.TextProgram;

/**
 * Solving a quadratic equation.
 */
public class Assignment2Part1 extends TextProgram {

    final static String SIGN_MINUS = "minus";
    final static String SIGN_PLUS = "plus";

    /**
     * Main method.
     */
    public void run() {
        // enter coefficients a, b, c.
        print("Please enter a:");
        int a = readInt();
        print("Please enter b:");
        int b = readInt();
        print("Please enter c:");
        int c = readInt();

        System.out.println(a + " " + b + " " + c);

        if (a == 0) {
            System.out.println("It`s not a quadratic equation");
            System.exit(-1);
        }

        // find the discriminant

        int theDiscriminant = (b * b) - (4 * a * c);
        System.out.println(theDiscriminant);

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
    private int theRoot(int discriminant, int a, int b, String sign) {
        if (sign.equals(SIGN_MINUS)) {
            return (int) (-b - Math.sqrt(discriminant)) / 2 * a;
        } else {
            return (int) (-b + Math.sqrt(discriminant)) / 2 * a;
        }
    }
}