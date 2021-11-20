package chamorro.edisson.pages;

import java.util.List;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;
import chamorro.edisson.utils.Constant;
import io.cucumber.datatable.DataTable;

public class PageLastMinuteDataCreditCard extends PageLastMinuteHome {

	public void payData(DataTable dataTable) {
		List<List<String>> listOfDataCard = dataTable.asLists(String.class);
		Action.sendData(getDriver(), By.xpath(String.format(Constant.GENERIC_INPUT_NAME, listOfDataCard.get(0).get(0))),
				listOfDataCard.get(1).get(0));
		Action.sendData(getDriver(), By.xpath(String.format(Constant.GENERIC_INPUT_NAME, listOfDataCard.get(0).get(1))),
				listOfDataCard.get(1).get(1));
		Action.sendData(getDriver(), By.xpath(String.format(Constant.GENERIC_INPUT_NAME, listOfDataCard.get(0).get(2))),
				listOfDataCard.get(1).get(2));
		Action.sendData(getDriver(), By.xpath(String.format(Constant.GENERIC_FORMAT_DIV_INPUT, "MM")),
				listOfDataCard.get(1).get(3) + listOfDataCard.get(1).get(4));
		Action.clickElement(getDriver(), By.xpath("//*[@id=\"privacyPolicy-label\"]/span[2]"));
		Action.genericButton(getDriver(), "Reservar ahora", Constant.GENERIC_FORMAT_BUTTON);
		Action.genericButton(getDriver(), "Acepta y continúa", Constant.GENERIC_FORMAT_SPAN);
		Action.genericButton(getDriver(), "Paga Ahora", Constant.GENERIC_FORMAT_SPAN);
	}

	public void verficiar(String message) {
		Action.verificarTexto(getDriver(), message, By.xpath(String.format(Constant.GENERIC_FORMAT_TEXT,
				"Lo sentimos Se ha producido un error y no hemos podido procesar tu solicitud de reserva")));
	}

}
