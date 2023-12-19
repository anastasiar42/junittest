package ie.atu.dip;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt user for age with input validation
		int age = promptForAge(input);

		InsuranceCalculator calculator = new InsuranceCalculator();
		
		// Validate for blank age
        calculator.validateForBlankAge(age);

		if (age < 25) {
			Under25InsuranceCalculator under25Calculator = new Under25InsuranceCalculator(calculator);
			under25Calculator.calculateInsurance(input, age);
		} else {
			Over25InsuranceCalculator over25Calculator = new Over25InsuranceCalculator(calculator);
			over25Calculator.calculateInsurance(input, age);
		}
	}

	// Method to prompt user for age with input validation
	private static int promptForAge(Scanner input) {
		int age = 0;
		boolean validInput = false;

		while (!validInput) {
			try {
				System.out.print("Enter your age: ");
				age = input.nextInt();

				// Validate age range
				if (age < 0 || age >= 99) {
					System.out.println("Please, enter valid age");
				} else {
					validInput = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please, enter valid age");
				input.nextLine(); // Clear the input buffer
			}
		}

		return age;
	}
}
