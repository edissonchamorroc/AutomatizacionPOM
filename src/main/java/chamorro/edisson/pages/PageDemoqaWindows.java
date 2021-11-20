package chamorro.edisson.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;
import net.serenitybdd.core.pages.PageObject;

public class PageDemoqaWindows extends PageObject {

	private static String textWindows1;
	private static String textWindows2;

	public void getTextWindow(String formatButton, String formatText, String pathButton, String pathText) {

		Action.clickElement(getDriver(), By.xpath(String.format(formatButton, pathButton)));
		textWindows1 = Action.getTextOtherWindow(getDriver(), By.xpath(String.format(formatText, pathText)));
		Action.clickElement(getDriver(), By.xpath(String.format(formatButton, pathButton)));
		textWindows2 = Action.getTextOtherWindow(getDriver(), By.xpath(String.format(formatText, pathText)));
		System.out.println(textWindows1);
	}

	public void verifyText(String originText) {
		assertEquals(originText, textWindows1);
		assertEquals(originText, textWindows2);
	}

}
