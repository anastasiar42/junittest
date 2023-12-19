package ie.atu.dip;
import java.util.Scanner;

//Calculator for individuals under 25 with specific logic
class Under25InsuranceCalculator extends InsuranceCalculator {
   private static final int SURCHARGE_UNDER_25 = 100;
   
    // Constructor to set total amount including surcharge
    public Under25InsuranceCalculator(InsuranceCalculator calculator) {
       setTotalAmount(BASIC_INSURANCE + SURCHARGE_UNDER_25 + super.getSurcharge());
    }

   // Pass age to calculateAndDisplayResult to perform age validation
   public void calculateInsurance(Scanner input, int age) {
       calculateAndDisplayResult(input, age);
    } 
    // Override getSurcharge to include the specific under 25 surcharge
   @Override
    protected int getSurcharge() {
		return SURCHARGE_UNDER_25 + super.getSurcharge();
    }

	public int getTotalAmount() {
		return totalAmount+super.getSurcharge();
	}
}

