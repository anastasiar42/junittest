package ie.atu.dip;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InsuranceCalculatorTest {

    private static InsuranceCalculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new InsuranceCalculator();
    }
    
    @AfterAll
    public static void tearDown() {
        // Clean up resources if needed

        // Clear console
        clearConsole();
    }
    @DisplayName("Calculate No Insurance")
    @ParameterizedTest(name = "Age: {0}, Accidents: {1}")
    @CsvSource({
            "16, 6, No insurance",
            "17, 6, No insurance",
            "24, 6, No insurance",
            "25, 6, No insurance",
            "26, 6, No insurance",
            "98, 6, No insurance",
            "99, 6, No insurance"
    })
    public void testCalculateInsurance(int age, int accidents, String expectedResult) {
        // Act
        String input = accidents + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method
        calculator.displayResultWithSurcharge(accidents);

        // Reset System.out to its original state
        System.setOut(System.out);

        // Get the captured output as a String
        String actualResult = outputStream.toString().trim();
       
        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Exception for Invalid Age")
    void testInvalidAgeException() {
        assertThrows(InputMismatchException.class, () -> {
            String input = "invalidAge\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            Scanner scanner = new Scanner(in);
            calculator.calculateAndDisplayResult(scanner);
        });
    }

    @Test
    @DisplayName("Test Exception for Blank Age")
    void testBlankAgeException() {
        assertThrows(NoSuchElementException.class, () -> {
            String input = "\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            Scanner scanner = new Scanner(in);
            calculator.calculateAndDisplayResult(scanner);
        });
    }
    private static void clearConsole() {
    	  // Number of empty lines to print to simulate clearing the console
        int consoleHeight = 50;
        
        // Print empty lines
        for (int i = 0; i < consoleHeight; i++) {
            System.out.println();
        }
    }
}
