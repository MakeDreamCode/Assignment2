package com.shpp.p2p.cs.oklymenchuk.assignment2;

import com.shpp.cs.a.console.TextProgram;

import java.util.*;

/**
 * Task 1. Solving a quadratic equation.
 */
public class Assignment2Part1 extends TextProgram {

    Map<String, Double> coefficientsMap = new HashMap<>();      // map for store coefficients and a discriminant

    private static final String DISCRIMINANT = "Discriminant";
    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";

    private static final String MSG_NO_ROOTS = "There are no real roots";
    private static final String MSG_HAS_ONE_ROOT = "There is one root: ";
    private static final String MSG_HAS_TWO_ROOTS = "There are two roots: ";
    private static final String MSG_AND = " and ";
    private static final String MSG_INPUT_PROMPT = "Please enter ";
    private static final String MSG_COLON = ": ";
    private static final String MSG_ERROR_INVALID_FORMAT = "Invalid format! Please, input the coefficient again!";

    /**
     * Main method.
     */
    public void run() {

        Coefficient[] coefficients = Coefficient.values();                          // take all names of constants from the Enum in an array

        for (Coefficient c: coefficients) {
            coefficientsMap.put(c.toString(), inputCoefficient(c.toString()));      // input coefficients
        }

        coefficientsMap.put(DISCRIMINANT, calculateDiscriminant(coefficientsMap));  // calculate and add the discriminant in Map

        List<Double> foundRoots = calculateRoots(coefficientsMap);                  // find all roots

        if (foundRoots.isEmpty()) {
            System.out.println(MSG_NO_ROOTS);                                       // show result
        }

        if (foundRoots.size() == 1) {
            System.out.println(MSG_HAS_ONE_ROOT + foundRoots.get(0));               // show result with one root
        }

        if (foundRoots.size() == 2) {
            System.out.println(MSG_HAS_TWO_ROOTS + foundRoots.get(0) + MSG_AND + foundRoots.get(1)); // show result with two root
        }
    }

    /**
     * Finding the roots of a quadratic equation.
     * The number of the required roots depends on the passed discriminant value.
     * @param coefficientsMap - Map<String, Double> contains pairs name : value, including discriminant.
     * @return List of founded roots.
     */
    private List<Double> calculateRoots(Map<String, Double> coefficientsMap) {

        List<Double> roots = new ArrayList<>();

        if (coefficientsMap.get(DISCRIMINANT) > 0){
            roots.add((-1 * coefficientsMap.get(B) + Math.sqrt(coefficientsMap.get(DISCRIMINANT))) /
                    (2 * coefficientsMap.get(A)));
            roots.add((-1 * coefficientsMap.get(B) - Math.sqrt(coefficientsMap.get(DISCRIMINANT))) /
                    (2 * coefficientsMap.get(A)));
        }

        if (coefficientsMap.get(DISCRIMINANT) == 0){
            roots.add(-1 * coefficientsMap.get(B) / (2 * coefficientsMap.get(A)));
        }

        return roots;
    }

    /**
     * Calculates a discriminant.
     * @param coefficientsMap - Map<String, Double> contains pairs name : value.
     * @return the calculated value of the discriminant.
     */
    private double calculateDiscriminant(Map<String, Double> coefficientsMap){
        return (coefficientsMap.get(B) * coefficientsMap.get(B)) -
                (4 * coefficientsMap.get(A) * coefficientsMap.get(C));
    }

    /**
     * Gets a coefficient value from the console.
     * @param coefficient - string contains the name of the coefficient.
     * @return value coefficient in double type
     */
    private double inputCoefficient(String coefficient){

        Scanner scanner = new Scanner(System.in);                                   // this stream can be left open (System.in)

        while (true){                                                               // loop until input valid value

            System.out.print(MSG_INPUT_PROMPT + coefficient + MSG_COLON);           // input prompt message

            if(scanner.hasNextDouble()){
                return scanner.nextDouble();                                        // exit the loop if the correct value was entered
            } else {
                System.out.println(MSG_ERROR_INVALID_FORMAT);                       // show error message and go to the next loop
                scanner.nextLine();
            }
        }
    }
}

enum Coefficient{
    A, B, C
}