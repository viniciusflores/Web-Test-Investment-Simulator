package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;
import project_constants.InvestmentProfileEnum;
import project_constants.TimeToInvestmentEnum;

public class InvestmentPage extends BasePage {
	public void submitInvestment(InvestmentProfileEnum type, String valueApply,String valueInvest, String time, TimeToInvestmentEnum typeTime) {
		scrollToElement(By.name("perfil"));
		selectProfile(type);
		setApplyValue(valueApply);
		setInvestValue(valueInvest);
		setInvestTime(time);
		setTimeOptions(typeTime);
		clickToSimulate();
	}

	public void selectProfile(InvestmentProfileEnum type) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("perfil")));
		List<WebElement> elements = driver.findElements(By.name("perfil"));
		if (type.toString().equalsIgnoreCase("PESSOA_JURIDICA")) {
			elements.get(1).click();
		} else if (type.toString().equalsIgnoreCase("PESSOA_FISICA")) {
			elements.get(0).click();
		}
	}

	public void setApplyValue(String value) {
		write(By.id("valorAplicar"), value);
	}

	public void setInvestValue(String value) {
		write(By.id("valorInvestir"), value);
	}

	public void setInvestTime(String time) {
		write(By.id("tempo"), time);
	}

	public void setTimeOptions(TimeToInvestmentEnum time) {
		click(By.className("seta"));
		if (time.toString().equalsIgnoreCase("MESES")) {
			click(By.xpath("//a[@rel='M' and contains(.,'Meses')]"));
		} else if (time.toString().equalsIgnoreCase("ANOS")) {
			click(By.xpath("//a[@rel='A' and contains(.,'Anos')]"));
		}
	}

	public void clearInvestmentForm() {
		click(By.className("btnLimpar"));
	}

	public void clickToSimulate() {
		click(By.className("btnSimular"));
	}

	public Boolean existsButtonRemakeSimulation() {
		return existElement(By.xpath("//a[@class=('btn btnAmarelo btnRefazer')]"));
	}
}
