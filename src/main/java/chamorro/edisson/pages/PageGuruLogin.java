package chamorro.edisson.pages;

import java.util.Map;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;
import chamorro.edisson.utils.Constant;
import net.serenitybdd.core.pages.PageObject;

public class PageGuruLogin extends PageObject {

	By fieldUser = By.name("uid");
	By fieldPass = By.name("password");

	public void navegateTo(String url) {

		Action.navegateToUrl(getDriver(), url);
	}

	public void logear(Map<String, String> dataUser) {
		System.out.println("---------------"+dataUser.get("user")+"----------"+dataUser.get("password")+"-----------"+dataUser.get("button name"));
		Action.sendData(getDriver(), fieldUser, dataUser.get("user"));
		Action.sendData(getDriver(), fieldPass, dataUser.get("password"));
		Action.clickElement(getDriver(),
				By.xpath(String.format(Constant.GENERIC_INPUT_VALUE, dataUser.get("button name"))));
	}

}
