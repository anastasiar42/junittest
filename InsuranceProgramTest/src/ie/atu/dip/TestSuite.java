package ie.atu.dip;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;


@Suite
@SelectClasses({
	InsuranceCalculatorTest.class,
	Under25InsuranceCalculatorTest.class,
	Over25InsuranceCalculatorTest.class
})

public class TestSuite {
}