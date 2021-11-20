package chamorro.edisson.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;

public class PageAccountOverviewParabank extends PageNewAccountParabank {

	public void verificarNewAccount(String codigo, String namePage) {
		this.clicPage(namePage);
		String codigoXpath = "//*[text()='" + codigo + "']";
		By Codigo = By.xpath(codigoXpath);
		assertEquals(codigo, Action.getElementText(getDriver(), Codigo));
	}

}
