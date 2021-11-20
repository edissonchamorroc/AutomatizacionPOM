package chamorro.edisson.pages;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;
import net.serenitybdd.core.pages.PageObject;


public class PageLoginParabank extends PageObject{
	
	By fieldUser = By.name("username");
	By fieldPass = By.name("password");
	By btnLogin = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
	
	
	public void navegateTo(String url) {
		Action.navegateToUrl(getDriver(), url);
	} 
	
	public void logear(String user, String pass) {
		
		Action.sendData(getDriver(), fieldUser, user);
		Action.sendData(getDriver(), fieldPass, pass);
		Action.clickElement(getDriver(), btnLogin);
	}  

}
