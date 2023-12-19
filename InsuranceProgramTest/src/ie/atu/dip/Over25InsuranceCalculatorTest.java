package ie.atu.dip;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class Over25InsuranceCalculatorTest {
private InsuranceCalculator calculator;
private Over25InsuranceCalculator over25Calculator;

    @BeforeEach
    void setUp() {
        calculator = new InsuranceCalculator();
        over25Calculator = new Over25InsuranceCalculator(calculator);
    }
    @AfterEach
    void cleanUp() {
        // Consume remaining input after each test
        consumeRemainingInput();
    }

    @DisplayName("Calculate Insurance with 1-5 Accidents")
    @ParameterizedTest(name = "Age: {0}, Accidents: {1}, Surcharge: {2}, Total Amount: {3}")
    @CsvSource({
            "25, 1, 50, 550",
            "26, 1, 50, 550",
            "98, 1, 50, 550",
            "99, 1, 50, 550",
            "25, 2, 125, 625",
            "26, 2, 125, 625",
            "98, 2, 125, 625",
            "99, 2, 125, 625",
            "25, 3, 225, 725",
            "26, 3, 225, 725",
            "98, 3, 225, 725",
            "99, 3, 225, 725",
            "25, 4, 375, 875",
            "26, 4, 375, 875",
            "98, 4, 375, 875",
            "99, 4, 375, 875",
            "25, 5, 575, 1075",
            "26, 5, 575, 1075",
            "98, 5, 575, 1075",
            "99, 5, 575, 1075"          
    })
    
   public void testCalculateInsuranceWithAccidents(int age, int accidents, int expectedSurcharge, int expectedTotalAmount) {
        // Act
        String input = accidents + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        over25Calculator.calculateInsurance(scanner, age);

        // Assert
        assertEquals(expectedSurcharge, over25Calculator.getSurcharge());
        assertEquals(expectedTotalAmount, over25Calculator.getTotalAmount());
    }
    @DisplayName("Calculate Insurance with 0 Accidents")
    @ParameterizedTest(name = "Age: {0}, Accidents: {1}, Surcharge: {2}, Total Amount: {3}")
    @CsvSource({
            "25, 0, 0, 500",
            "26, 0, 0, 500",
            "98, 0, 0, 500"        
    })
    
   public void testCalculateInsuranceWithNoAccidents(int age, int accidents, int expectedSurcharge, int expectedTotalAmount) {
        // Act
        String input = accidents + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        over25Calculator.calculateInsurance(scanner, age);

        // Assert
        assertEquals(expectedSurcharge, over25Calculator.getSurcharge());
        assertEquals(expectedTotalAmount, over25Calculator.getTotalAmount());
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

