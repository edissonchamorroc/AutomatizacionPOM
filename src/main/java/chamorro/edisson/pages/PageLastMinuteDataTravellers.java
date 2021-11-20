package chamorro.edisson.pages;

import java.util.List;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;
import chamorro.edisson.utils.Constant;
import io.cucumber.datatable.DataTable;

public class PageLastMinuteDataTravellers extends PageLastMinuteHome {

	public void sendDataTravelers(DataTable dataTable) {

		List<List<String>> radioList = dataTable.asLists(String.class);
		Action.genericButton(getDriver(), "radio-groups.1.travellers.1.title-" + radioList.get(1).get(0) + "-label",
				Constant.GENERIC_FORMAT_LABEL_ID);
		Action.genericButton(getDriver(), "radio-groups.1.travellers.2.title-" + radioList.get(1).get(1) + "-label",
				Constant.GENERIC_FORMAT_LABEL_ID);
		Action.sendPartialdataTable(getDriver(), dataTable, Constant.GENERIC_INPUT_TYPE, "text", "no", 2, 6);
		Action.sendPartialdataTable(getDriver(), dataTable, Constant.GENERIC_INPUT_TYPE, "tel", "no", 6, 10);
		Action.sendPartialdataTable(getDriver(), dataTable, Constant.GENERIC_FORMAT_DIV_CLASS + "//descendant::select",
				"form-control-wrapper", "no", 10, 12);

	}

	public void sendDataReserved(DataTable dataTable) {
		Action.sendList(getDriver(), dataTable, Constant.GENERIC_INPUT_NAME, 8);
		Action.sendPartialdataTable(getDriver(), dataTable, Constant.GENERIC_FORMAT_DIV_CLASS, "selected-dial-code",
				"si", 8, 9);
		Action.sendPartialdataTable(getDriver(), dataTable, Constant.GENERIC_FORMAT_DIV_CLASS, " css-1hwfws3", "si", 9,
				9);

		int maleta1 = Action.returnWebDriverElements(getDriver(),
				Constant.GENERIC_FORMAT_ID
						+ "/div/div[2]/div/div/div[2]/div[5]/div/div[1]/div/div[4]/div[1]/div/div/label",
				"root").size();

		System.out.println(maleta1);

		if (maleta1 != 0) {

			Action.clickElement(getDriver(), By.xpath(
					"//*[@id='root']/div/div[2]/div/div/div[2]/div[5]/div/div[1]/div/div[4]/div[1]/div/div/label"));
		} else {
			Action.genericButton(getDriver(), "radio-1-1-1-ADT_1-BAG_0", Constant.GENERIC_FORMAT_ID);
			Action.genericButton(getDriver(), "radio-1-2-1-ADT_1-BAG_0", Constant.GENERIC_FORMAT_ID);
			Action.genericButton(getDriver(), "radio-1-1-2-ADT_2-BAG_0", Constant.GENERIC_FORMAT_ID);
			Action.genericButton(getDriver(), "radio-1-2-2-ADT_2-BAG_0", Constant.GENERIC_FORMAT_ID);

		}

		Action.genericButton(getDriver(), "Siguiente", Constant.GENERIC_FORMAT_BUTTON);
		Action.genericButton(getDriver(), "Siguiente", Constant.GENERIC_FORMAT_BUTTON);

	}

}
