# JUnit automated test suite

@author Anastasiia Ryzhkova
@version Java 21


# Refactoring
```
The source code InsuranceProgram.java has been refactored with the aim to make the code suitable for creation and running of the automated test suite. 
The following classes have been added:
○ InsuranceCalculator.java which is base class for insurance calculation with shared logic for both age groups
○ Under25InsuranceCalculator.java which performs calculation for individuals under 25 with specific logic
○ Over25InsuranceCalculator.java which performs calculation for individuals 25 and older with specific logic
○ InsuranceConstants.java which contains constants related to insurance calculations
○ Runner.java class to run the application
Also the age validation has been added with assumption that valid age range is 16-99, with specific logic for under 25 and 25 and over age groups.
Validation ensures that user inputs valid age 16-99 and prompts user in case user enters invalid age (e.g. sixteen or age <16 and >99).
The invalid age and blank age are tested for correct exceptions in InsuranceCalculatorTest.class.

```
# Test Suite
Test design has been performed using Boundary Value Analysis and Equivalence Partitioning techniques.

# Coverage
The coverage is 78.9 %
# To Run

```
Application can be run from Eclipse by Running TestSuite.class or by selecting Coverage as JUnit Test
```


