package ie.atu.dip;
import java.util.Scanner;

//Calculator for individuals 25 and older with specific logic
class Over25InsuranceCalculator extends InsuranceCalculator {
	 // Constructor to set total amount without surcharge	
    public Over25InsuranceCalculator(InsuranceCalculator calculator) {
        setTotalAmount(BASIC_INSURANCE);
    }

    // Pass age to calculateAndDisplayResult to perform age validation
    public void calculateInsurance(Scanner input, int age) {
        calculateAndDisplayResult(input, age);
    }
}
