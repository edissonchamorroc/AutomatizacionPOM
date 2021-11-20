package chamorro.edisson.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;
import chamorro.edisson.utils.Constant;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;

public class PageGuruLogin extends PageObject {
	By fieldTarget;
	By fieldUser = By.name("uid");
	By fieldPass = By.name("password");

	public void navegateTo(String url) {
		Action.navegateToUrl(getDriver(), url);
	}

	public void logear(DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

		Action.sendData(getDriver(), By.name(list.get(0).get("idTarget")), list.get(0).get("data"));
		Action.sendData(getDriver(), By.name(list.get(1).get("idTarget")), list.get(1).get("data"));
		Action.clickElement(getDriver(),
				By.xpath(String.format(Constant.GENERIC_INPUT_VALUE, list.get(2).get("idTarget"))));
	}

}
