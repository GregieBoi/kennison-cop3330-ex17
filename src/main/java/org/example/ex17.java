/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 McGreggor Kennison
 */


package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ex17 {

    // main
    public static void main(String[] args) {

        // passes to BAC_Calc
        BAC_Calc();
    }

    // gathers variables and passes to can_drive in end
    public static void BAC_Calc() {

        // initialize variables
        int gender = get_gender();
        double ounces = get_ounces();
        double weight = get_weight();
        double hours = get_hours();

        // initialize BAC
        double BAC = calculate(gender, ounces, weight, hours);

        // passes to can_drive
        can_drive(BAC);


    }

    // gets gender
    public static int get_gender() {

        // prompts for input and returns scan
        System.out.print("Enter a 1 if you are male or a 2 if you are female: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();

    }

    // gets ounces of alcohol
    public static double get_ounces() {

        // prompts for input and returns scan
        System.out.print("How many ounces of alcohol did you have? ");
        Scanner input = new Scanner(System.in);
        return input.nextDouble();

    }

    // gets weight
    public static double get_weight() {

        // prompts for input and returns scan
        System.out.print("What is your weight, in pounds? ");
        Scanner input = new Scanner(System.in);
        return input.nextDouble();

    }

    // gets hours since last drink
    public static double get_hours() {

        // prompts for input and returns scan
        System.out.print("How many hours has it been since your last drink? ");
        Scanner input = new Scanner(System.in);
        return input.nextDouble();

    }

    // calculates blood alcohol level
    public static double calculate(int gender, double ounces, double weight, double hours) {

        // initialize BAC as zero
        double BAC = 0;

        // determines gender and applies proper equation or set to -1 if number does not correlate
        if (gender == 1)
            BAC = (ounces * 5.14 / weight * .73) - (.015 * hours);
        else if (gender == 2)
            BAC = (ounces * 5.14 / weight * .66) - (.015 * hours);
        else
            BAC = -1;

        // returns result
        return BAC;

    }

    // determines if user can drive
    public static void can_drive(double BAC) {

        // sets format
        DecimalFormat df = new DecimalFormat("#.######");

        // determines if BAC is too high or if gender was valid
        if (BAC >= .08) {

            // prints output
            System.out.println("Your BAC is " + df.format(BAC));
            System.out.println("It is not legal for you to drive.");
        }
        else if (0 <= BAC) {

            // prints output
            System.out.println("Your BAC is " + df.format(BAC));
            System.out.println("It is legal for you to drive.");
        }
        else if (BAC == -1)
            // prompts for restart and to enter proper gender
            System.out.println("please restart the program and choose a proper gender");
    }
}
