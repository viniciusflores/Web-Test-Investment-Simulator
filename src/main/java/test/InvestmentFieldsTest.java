package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import core.BaseTest;
import page.InvestmentPage;

/**
 * 
 * @author vinicius.flores
 *
 */
public class InvestmentFieldsTest extends BaseTest {
	private InvestmentPage page = new InvestmentPage();

	@Test
	public void verifyValueToApplyLessThanTwenty() {
		page.setApplyValue("1000");
		page.sendKeyTab(By.id("valorAplicar"));
		assertEquals(page.getText(By.id("valorAplicar-error")), "Valor mínimo de 20.00");
	}

	@Test
	public void verifyValueToInvestLessThanTwenty() {
		page.setInvestValue("1000");
		page.sendKeyTab(By.id("valorInvestir"));
		assertEquals(page.getText(By.id("valorInvestir-error")), "Valor mínimo de 20.00");
	}

	@Test
	public void verifyTimeToInvestmentValid() {
		page.setInvestTime("0");
		page.sendKeyTab(By.id("tempo"));
		assertEquals(page.getText(By.id("tempo-error")), "Valor esperado não confere");
	}

	@Test
	public void verifyTimeToInvestmentRequired() {
		page.clickToSimulate();
		assertEquals(page.getText(By.id("tempo-error")), "Obrigatório");
	}

}
