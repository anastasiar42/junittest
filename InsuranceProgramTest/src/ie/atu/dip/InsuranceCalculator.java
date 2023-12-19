package ie.atu.dip;

import java.util.Scanner;

// Base class for insurance calculation with shared logic
class InsuranceCalculator {
    protected static final int BASIC_INSURANCE = 500;
    protected int totalAmount;
    private int surcharge;

    public int setTotalAmount(int totalAmount) {
        return this.totalAmount = totalAmount;
    }

    // Overloaded method to support age validation
    public void calculateAndDisplayResult(Scanner input) {
        calculateAndDisplayResult(input, -1);
    }

    // Overloaded method to support age validation
    public void calculateAndDisplayResult(Scanner input, int age) {
        int accidents = getAccidentCount(input);

        // Perform age validation if age is provided
        if (age != -1 && (age < 16 || age > 99)) {
            System.out.println("No insurance");
        } else {
            if (accidents == 0) {
                System.out.println("No accidents, total amount to pay: " + totalAmount);
            } else {
                displayResultWithSurcharge(accidents);
            }
        }
    }

    public int getAccidentCount(Scanner input) {
        System.out.print("\nHow many accidents did you have? ");
        return input.nextInt();
    }

    public void displayResultWithSurcharge(int accidents) {
        surcharge = calculateSurchargeAmount(accidents);  // Update the surcharge
        if (accidents >= InsuranceConstants.MAX_ACCIDENTS_WITHOUT_INSURANCE) {
            System.out.println("No insurance");
        } else if (accidents < 6) {
            System.out.println("Additional surcharge for accident: " + surcharge +
                    "\nTotal amount to pay: " + (totalAmount + surcharge));
        }
    }
    protected int getTotalAmount() {
    	return totalAmount+surcharge;
    }

    public int calculateSurchargeAmount(int accidents) {
        int[] surchargeValues = {0, 50, 125, 225, 375, 575};
        return (accidents >= 1 && accidents <= surchargeValues.length - 1) ? surchargeValues[accidents] : 0;
    }

    protected int getSurcharge() {
        return surcharge;
    }
    public void validateForBlankAge(int age) {
        if (age == 0) {
            throw new IllegalArgumentException("Age cannot be blank");
        }
    }
}
