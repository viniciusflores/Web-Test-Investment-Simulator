package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.BaseTest;
import page.InvestmentPage;
import project_constants.InvestmentProfileEnum;
import project_constants.TimeToInvestmentEnum;

/**
 * 
 * @author vinicius.flores
 *
 */
public class InvestmentTest extends BaseTest {
	private InvestmentPage page = new InvestmentPage();

	@DataProvider(name = "physicalWithMonths")
	public static Object[][] physicalWithMonths() {
		return new Object[][] {
				{ InvestmentProfileEnum.PHYSICAL_PERSON, "100000", "40000", "6", TimeToInvestmentEnum.MONTHS } };
	}

	@DataProvider(name = "physicalWithYears")
	public static Object[][] physicalWithYears() {
		return new Object[][] {
				{ InvestmentProfileEnum.PHYSICAL_PERSON, "200000", "30000", "3", TimeToInvestmentEnum.YEARS } };
	}

	@DataProvider(name = "legalWithMonths")
	public static Object[][] legalWithMonths() {
		return new Object[][] {
				{ InvestmentProfileEnum.LEGAL_ENTITY, "300000", "20000", "12", TimeToInvestmentEnum.MONTHS } };
	}

	@DataProvider(name = "legalWithYears")
	public static Object[][] legalWithYears() {
		return new Object[][] {
				{ InvestmentProfileEnum.LEGAL_ENTITY, "400000", "10000", "10", TimeToInvestmentEnum.YEARS } };
	}

	@Test(dataProvider = "physicalWithMonths")
	public void submitInvestimentPhysicalWithMonths(InvestmentProfileEnum profile, String applyValue,
			String investValue, String time, TimeToInvestmentEnum typeTime) {
		page.submitInvestment(profile, applyValue, investValue, time, typeTime);
		assertTrue(page.existsButtonRemakeSimulation());
		String[] resultTime = page.validateTimeByTimeType(time, typeTime);
		assertEquals(page.getValueOfInvestmentTime(), resultTime);
	}

	@Test(dataProvider = "physicalWithYears")
	public void submitInvestimentPhysicalWithYears(InvestmentProfileEnum profile, String applyValue, String investValue,
			String time, TimeToInvestmentEnum typeTime) {
		page.submitInvestment(profile, applyValue, investValue, time, typeTime);
		assertTrue(page.existsButtonRemakeSimulation());
		String[] resultTime = page.validateTimeByTimeType(time, typeTime);
		assertEquals(page.getValueOfInvestmentTime(), resultTime);
	}

	@Test(dataProvider = "legalWithMonths")
	public void submitInvestimentLegalWithMonths(InvestmentProfileEnum profile, String applyValue, String investValue,
			String time, TimeToInvestmentEnum typeTime) {
		page.submitInvestment(profile, applyValue, investValue, time, typeTime);
		assertTrue(page.existsButtonRemakeSimulation());
		String[] resultTime = page.validateTimeByTimeType(time, typeTime);
		assertEquals(page.getValueOfInvestmentTime(), resultTime);
	}

	@Test(dataProvider = "legalWithYears")
	public void submitInvestimentLegalWithYears(InvestmentProfileEnum profile, String applyValue, String investValue,
			String time, TimeToInvestmentEnum typeTime) {
		page.submitInvestment(profile, applyValue, investValue, time, typeTime);
		assertTrue(page.existsButtonRemakeSimulation());
		String[] resultTime = page.validateTimeByTimeType(time, typeTime);
		assertEquals(page.getValueOfInvestmentTime(), resultTime);
	}

}
