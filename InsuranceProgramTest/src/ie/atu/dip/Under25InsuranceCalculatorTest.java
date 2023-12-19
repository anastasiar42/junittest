package ie.atu.dip;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class Under25InsuranceCalculatorTest {
private InsuranceCalculator calculator;
private Under25InsuranceCalculator under25Calculator;

    @BeforeEach
    void setUp() {
        calculator = new InsuranceCalculator();
        under25Calculator = new Under25InsuranceCalculator(calculator);
    }
    @AfterEach
    void cleanUp() {
        // Consume remaining input after each test
        consumeRemainingInput();
    }

    @DisplayName("Calculate Insurance with 0-5 Accidents")
    @ParameterizedTest(name = "Age: {0}, Accidents: {1}, Surcharge: {2}, Total Amount: {3}")
    @CsvSource({
            "16, 0, 100, 600",
            "17, 0, 100, 600",
            "24, 0, 100, 600",
            "16, 1, 150, 650",
            "17, 1, 150, 650",
            "24, 1, 150, 650",
            "16, 2, 225, 725",
            "17, 2, 225, 725",
            "24, 2, 225, 725", 
            "16, 3, 325, 825", 
            "17, 3, 325, 825",
            "24, 3, 325, 825", 
            "16, 4, 475, 975",
            "17, 4, 475, 975",
            "24, 4, 475, 975",
            "16, 5, 675, 1175",
            "17, 5, 675, 1175",
            "24, 5, 675, 1175"
	 
            
            
    })
    
   public void testCalculateInsurance(int age, int accidents, int expectedSurcharge, int expectedTotalAmount) {
        // Act
        String input = accidents + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        under25Calculator.calculateInsurance(scanner, age);

        // Assert
        assertEquals(expectedSurcharge, under25Calculator.getSurcharge());
        assertEquals(expectedTotalAmount, under25Calculator.getTotalAmount());
    }
    private void consumeRemainingInput() {
    	  // Number of empty lines to print to simulate clearing the console
        int consoleHeight = 50;
        
        // Print empty lines
        for (int i = 0; i < consoleHeight; i++) {
            System.out.println();
        }
    }
}
