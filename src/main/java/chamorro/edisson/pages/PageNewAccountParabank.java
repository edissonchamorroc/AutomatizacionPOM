package chamorro.edisson.pages;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;
import net.serenitybdd.core.pages.PageObject;

public class PageNewAccountParabank extends PageObject {

	public void clicPage(String namePage) {
		String generic="//*[text()='%s']";
		By btnNew = By.xpath(String.format(generic, namePage));
		Action.clickElement(getDriver(), btnNew);
	}

	public void chooseSaving() {
		By btn = By.xpath("//*[@id=\"type\"]/option[2]");
		Action.clickElement(getDriver(), btn);
	} 
 
	
	public void btnGeneric(String xpath) {
		String formato="//input[@value='%s']";
		By btn= By.xpath(String.format(formato,xpath));
		Action.clickElement(getDriver(), btn);
	}
	
	
	public void codeNewAccount() {
		By codeXpath = By.xpath("//*[@id=\"newAccountId\"]");
		code=Action.getElementText(getDriver(), codeXpath);
		
	}
	
	public void creacionCuenta(String nameBtn) {
		this.chooseSaving();
		this.btnGeneric(nameBtn);
		this.codeNewAccount();
	}
	
	public String codigo() {
		return code;
	} 
	
	
	String code;
	
}
