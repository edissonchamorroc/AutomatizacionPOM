package chamorro.edisson.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import chamorro.edisson.actions.Action;
import chamorro.edisson.utils.Constant;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;

public class PageLastMinuteHome extends PageObject {
	Action action;
    public void choiceOption(String nameButton) {
    	
    	Action.genericButton(getDriver(),"ACEPTAR TODAS", Constant.GENERIC_FORMAT_BUTTON);
		Action.genericButton(getDriver(),nameButton, Constant.GENERIC_FORMAT_SPAN);  
    }
	public void sendDataTravel(DataTable dataTable, String typeGenericToSearch, String genericComplementToSearch,
			String genericComplementToClick, String attribute) {

		List<WebElement> idOfElements = Action.returnWebDriverElements(getDriver(), typeGenericToSearch,
				genericComplementToSearch);
		List<List<String>> table = dataTable.asLists(String.class); 

		for (int i = 0; i < table.get(0).size(); i++) { 

			if (i == 2) { 
				adultNumber(Integer.parseInt(table.get(1).get(i)));
			} else {
				Action.sendData(getDriver(), By.xpath(
						String.format(Constant.GENERIC_FORMAT_ID, idOfElements.get(i + 2).getAttribute(attribute))),
						table.get(1).get(i));

				Action.genericButton(getDriver(), table.get(1).get(i), genericComplementToClick);
			}

		}
		Action.genericButton(getDriver(), "Buscar",
				"//div[@class='btn btn-cta btn-block lmn-sw-submitFlight' and text()='%s']");
	}
 
	public void adultNumber(Integer number) {
		Action.genericButton(getDriver(), "passengersText lmn-sw-responsive-form-field lmn-sw-tooltip-responsive__text",
				Constant.GENERIC_FORMAT_DIV_CLASS);
		for (int i = 0; i < number - 1; i++) {
			Action.genericButton(getDriver(), "icon icon-plus",
					"//div[@class='passengerSelectionRow']//descendant::span[@class='%s']");
		}

	}
}
