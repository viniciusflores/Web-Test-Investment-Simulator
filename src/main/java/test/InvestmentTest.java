package test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import core.BaseTest;
import page.InvestmentPage;
import project_constants.InvestmentProfileEnum;
import project_constants.TimeToInvestmentEnum;

public class InvestmentTest extends BaseTest {
	private InvestmentPage page = new InvestmentPage();
	
	@Test
	public void submitInvestimentPF() {
		page.submitInvestment(InvestmentProfileEnum.PESSOA_FISICA, "20000","5000", "6", TimeToInvestmentEnum.MESES);
		assertTrue(page.existsButtonRemakeSimulation());
	}

	

}
