package chamorro.edisson.pages;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;
import chamorro.edisson.utils.Constant;
import io.cucumber.datatable.DataTable;

public class PageGuruRegister extends PageGuruLogin {

	By btnSubmit;
	By genericTarget;

	public void registro(String fieldName, String data) {
		By fieldGeneric = By.name(fieldName);
		Action.sendData(getDriver(), fieldGeneric, data);
	}

	public void btnOption(String btnName) {
		By btn = By.xpath(String.format(Constant.GENERIC_FORMAT_TEXT, btnName));
		Action.clickElement(getDriver(), btn);
	}

	public void submit(String nameBotton) {
		Action.clickElement(getDriver(), By.xpath(String.format(Constant.GENERIC_INPUT_VALUE, nameBotton)));
	}

	public void fillData(DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).get("data").equalsIgnoreCase("f")) {
				Action.clickElement(getDriver(), By.xpath(String.format(Constant.GENERIC_INPUT_VALUE, "f")));
			} else if (list.get(i).get("idTarjet").equalsIgnoreCase("email")) {
				registro(list.get(i).get("idTarjet"), randomEmail(list.get(i).get("data")));
			} else {
				registro(list.get(i).get("idTarjet"), list.get(i).get("data"));
			}

		}
	}

	public String randomEmail(String dataToChange) {
		Random random = new Random();
		String data;
		String[] split = dataToChange.split("@");
		String setOfCharacters = "abcdefghiABCDEFGHI0123456789";
		int randomInt = random.nextInt(setOfCharacters.length());

		for (int i = 0; i < 5; i++) {
			split[0] += setOfCharacters.charAt(randomInt);
		}
		data = split[0] + split[1];
		return data;

	}

	public void verificarRegistro(String texto) {

		genericTarget = By.xpath(String.format(Constant.GENERIC_FORMAT_TEXT, texto));

		Action.verificarTexto(getDriver(), texto, genericTarget);
	}

}
