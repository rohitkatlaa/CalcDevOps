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
        double num1, num2, result;
        while(true) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Scientific Calculator with DevOps , Choose an operation to calculate:");
            System.out.println("1. Square root");
            System.out.println("2. Factorial");
            System.out.println("3. Power");
            System.out.println("4. Natural Log");
            System.out.println("5. Exit");
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
                case 3:
                    System.out.print("Enter the first number : ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    num2 = scanner.nextDouble();
                    System.out.println(num1+ " raised to power "+num2+" is : " + calculator.power(num1, num2));
                    break;
                case 4:
                    System.out.print("Enter a number : ");
                    num1 = scanner.nextDouble();
                    System.out.println("Natural log of "+num1+" is : " + calculator.naturalLog(num1));
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

    public double power(double num1, double num2) {
        logger.info("[POWER - " + num1 + " RAISED TO] " + num2);
        double result = Math.pow(num1,num2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double naturalLog(double num1) {
        logger.info("[NATURAL LOG] - " + num1);
        double result = 0;
        try {

            if (num1 <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                result = Math.log(num1);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }
}