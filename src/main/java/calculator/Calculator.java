package calculator;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator() {
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double num1, result;
        while(true) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Scientific Calculator with DevOps , Choose an operation to calculate:");
            System.out.println("1. Square root");
            System.out.println("2. Factorial");
            System.out.println("3. Exit");
            System.out.println("----------------------------------------------------------------------");
            System.out.print("Enter an option:");
            int option;
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException error) {
                System.out.println("Please enter a valid option.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Enter a number:");
                    num1 = scanner.nextDouble();
                    result = calculator.sqroot(num1);
                    System.out.println("Square root of " + num1 + " is : " + result);
                    break;
                case 2:
                    System.out.print("Enter a number : ");
                    num1 = scanner.nextDouble();
                    result = calculator.factorial(num1);
                    System.out.println("Factorial of " + num1 + " is : " + result);
                    break;
                default:
                    System.out.println("Thank you for using Scientific Calculator with DevOps!!");
                    scanner.close();
                    return;
            }
        }
    }


    public double sqroot(double num1) {
        logger.info("[SQUARE ROOT] - " + num1);
        double result = Math.sqrt(num1);
        logger.info("[RESULT - SQUARE ROOT] - " + result);
        return result;
    }

    public double factorial(double num1) {
        logger.info("[FACTORIAL] - " + num1);
        double result = 1;
        for(int i = 1; i <= num1; ++i) {
            result *= i;
        }
        logger.info("[RESULT - FACTORIAL] - " + result);
        return result;
    }
}