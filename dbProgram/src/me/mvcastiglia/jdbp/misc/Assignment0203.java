package me.mvcastiglia.jdbp.misc;
import java.util.Scanner;

// Tax Estimator 5000
public class Assignment0203 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your 2020 taxable income: ");
        double taxableIncome = scan.nextDouble();

        scan.close();
        double tax = calculateSingleIncomeTax(taxableIncome);
        System.out.println("Your estimated 2020 income tax (filed single) is " + tax + ".");

        tax = calculateMarriedJointIncomeTax(taxableIncome);
        System.out.println("Your estimated 2020 income tax (joint married) is " + tax + ".");

        tax = calculateMarriedSeparateIncomeTax(taxableIncome);
        System.out.println("Your estimated 2020 income tax (separate married) is " + tax + ".");

        tax = calculateHeadOfHouseholdIncomeTax(taxableIncome);
        System.out.println("Your estimated 2020 income tax (HOH) is " + tax + ".");
    }

    public static double calculateSingleIncomeTax(double n) {
        if(n <= 9875) {
            return 0.1 * n;
        } else if(n <= 40125) {
            return 987.50 + 0.12 * (n - 9875);
        } else if(n <= 85525) {
            return 4617.50 + 0.22 * (n - 40125);
        } else if(n <= 163300) {
            return 14605.50 + 0.24 * (n - 85525);
        } else if(n <= 207350) {
            return 33271.50 + 0.32 * (n - 163300);
        } else if(n <= 518400) {
            return 47367.50 + 0.35 * (n - 207350);
        } else {
            return 156235 + 0.37 * (n - 518400);
        }
    }

    public static double calculateMarriedJointIncomeTax(double n) {
        if(n <= 19750) {
            return 0.1 * n;
        } else if(n <= 80250) {
            return 1975 + 0.12 * (n - 19750);
        } else if(n <= 171050) {
            return 9235 + 0.22 * (n - 80250);
        } else if(n <= 326600) {
            return 29211 + 0.24 * (n - 171050);
        } else if(n <= 414700) {
            return 66543 + 0.32 * (n - 326600);
        } else if(n <= 622050) {
            return 94735 + 0.35 * (n - 414700);
        } else {
            return 167307.5 + 0.37 * (n - 622050);
        }
    }

    public static double calculateMarriedSeparateIncomeTax(double n) {
        if(n <= 9875) {
            return 0.1 * n;
        } else if(n <= 40125) {
            return 987.50 + 0.12 * (n - 9875);
        } else if(n <= 85525) {
            return 4617.50 + 0.22 * (n - 40125);
        } else if(n <= 163300) {
            return 14605.50 + 0.24 * (n - 85525);
        } else if(n <= 207350) {
            return 33271.50 + 0.32 * (n - 163300);
        } else if(n <= 518400) {
            return 47367.50 + 0.35 * (n - 207350);
        } else {
            return 156235 + 0.37 * (n - 518400);
        }
    }

    public static double calculateHeadOfHouseholdIncomeTax(double n) {
        if(n <= 14100) {
            return 0.1 * n;
        } else if(n <= 53700) {
            return 1410 + 0.12 * (n - 14100);
        } else if(n <= 85500) {
            return 6162 + 0.22 * (n - 53700);
        } else if(n <= 163300) {
            return 13158 + 0.24 * (n - 85500);
        } else if(n <= 207350) {
            return 31830 + 0.32 * (n - 163300);
        } else if(n <= 518400) {
            return 45926 + 0.35 * (n - 207350);
        } else {
            return 154793.5 + 0.37 * (n - 518400);
        }
    }

}
