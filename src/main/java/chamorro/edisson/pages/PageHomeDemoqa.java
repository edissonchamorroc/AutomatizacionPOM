package chamorro.edisson.pages;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;
import chamorro.edisson.utils.Constant;

public class PageHomeDemoqa extends PageGuruLogin {

	public void clickOption(String nameOption) {

		By election = By.xpath(String.format(Constant.GENERIC_FORMAT_TEXT, nameOption));
		Action.scrollDown(getDriver(), "300");
		Action.clickElement(getDriver(), election);
	}

}