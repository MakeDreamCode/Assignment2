package com.shpp.p2p.cs.oklymenchuk.assignment2;

import com.shpp.cs.a.console.TextProgram;

import java.util.*;

/**
 * Solving a quadratic equation. Версия для Алексея.
 */
public class Assignment2Part1 extends TextProgram {

    Map<String, Double> coefficientsMap = new HashMap<>();

    private static final String DISCRIMINANT = "Discriminant";

    /**
     * Main method.
     */
    public void run() {

        // take all constants from the Enum in an array
        Coefficient[] coefficients = Coefficient.values();

        // input coefficients
        for (Coefficient c: coefficients) {
            coefficientsMap.put(c.toString(), inputCoefficient(c.toString()));
        }

        // calculate and add the discriminant in Map
        coefficientsMap.put(DISCRIMINANT, calculateDiscriminant(coefficientsMap));

        /*// for debug only
        for (Map.Entry<String, Double> entry : coefficientsMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }*/

        // find all roots
        List<Double> foundRoots = calculateRoots(coefficientsMap);

        // show result
        if (foundRoots.isEmpty()) {
            System.out.println("There are no real roots");
        }

        if (foundRoots.size() == 1) {
            System.out.println("There is one root: " + foundRoots.get(0));
        }

        if (foundRoots.size() == 2) {
            System.out.println("There are two roots: " + foundRoots.get(0) + " and " + foundRoots.get(1));
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

            roots.add((-1 * coefficientsMap.get("b") + Math.sqrt(coefficientsMap.get(DISCRIMINANT))) /
                    (2 * coefficientsMap.get("a")));

            roots.add((-1 * coefficientsMap.get("b") - Math.sqrt(coefficientsMap.get(DISCRIMINANT))) /
                    (2 * coefficientsMap.get("a")));
        }

        if (coefficientsMap.get(DISCRIMINANT) == 0){
            roots.add(- coefficientsMap.get("b") / (2 * coefficientsMap.get("a")));
        }

        return roots;
    }

    /**
     * Calculates a discriminant.
     * @param coefficientsMap - Map<String, Double> contains pairs name : value.
     * @return the calculated value of the discriminant.
     */
    private double calculateDiscriminant(Map<String, Double> coefficientsMap){
        return (coefficientsMap.get("b") * coefficientsMap.get("b")) -
                (4 * coefficientsMap.get("a") * coefficientsMap.get("c"));
    }

    /**
     * Gets a coefficient value from the console.
     * @param coefficient - string contains the name of the coefficient.
     * @return value coefficient in double type
     */
    private double inputCoefficient(String coefficient){
        // этот поток можно не закрывать, так как это System.in
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

enum Coefficient{
    a, b, c
}