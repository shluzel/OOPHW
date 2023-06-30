package seminar07;

import seminar07.calculations.calculator;
import seminar07.calculations.complexcalculator;
import seminar07.complex.complexnumber;
import seminar07.message.message;
import seminar07.message.consolemessage;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        message message = new consolemessage(); 
        calculator calculator = new complexcalculator(message);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter real part of the first complex number:");
        double realfirst = scanner.nextDouble();
        System.out.println("Enter imaginary part of the first complex number:");
        double imaginaryfirst = scanner.nextDouble();
        complexnumber firstnum = new complexnumber(realfirst, imaginaryfirst);

        System.out.println("Enter real part of the second complex number:");
        double realsecond = scanner.nextDouble();
        System.out.println("Enter imaginary part of the second complex number:");
        double imaginarysecond = scanner.nextDouble();
        complexnumber secondnum = new complexnumber(realsecond, imaginarysecond);

        complexnumber summary = calculator.add(firstnum, secondnum);
        complexnumber multiplication = calculator.multiply(firstnum, secondnum);
        complexnumber division = calculator.divide(firstnum, secondnum);

        System.out.println("Summary: " + summary);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + division);

        scanner.close();
    }
}
