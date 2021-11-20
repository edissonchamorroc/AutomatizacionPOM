package chamorro.edisson.actions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import chamorro.edisson.pages.PageGuruRegister;
import chamorro.edisson.utils.Constant;
import io.cucumber.datatable.DataTable;

public class Action extends PageGuruRegister {

	public static void navegateToUrl(WebDriver myBrowser, String url) {

		myBrowser.navigate().to(url);

	}

	public static void sendData(WebDriver myBrowser, By target, String strData) {

		if (myBrowser.findElements(target).size() > 0) {

			myBrowser.findElement(target).sendKeys(strData);

		}
	}

	public static void clickElement(WebDriver myBrowser, By target) {

		if (myBrowser.findElements(target).size() > 0) {

			myBrowser.findElement(target).click();

		}
	}

	public static String getElementText(WebDriver myBrowser, By target) {

		if (myBrowser.findElements(target).size() > 0) {

			return myBrowser.findElement(target).getText();

		} else {

			String mensaje = "Missing element: " + target.toString();

			System.out.println(mensaje);

			return mensaje;
		}
	}

	public static void sendList(WebDriver myBroser, DataTable dataTable, String genericFormat, int limit) {

		List<List<String>> lista = dataTable.asLists(String.class);

		for (int i = 0; i < limit; i++) {

			clickElement(myBroser, By.xpath(String.format(genericFormat, lista.get(0).get(i))));

			sendData(myBroser, By.xpath(String.format(genericFormat, lista.get(0).get(i))), lista.get(1).get(i));

		}
	}

	public static void scrollDown(WebDriver myBrowser, String numScroll) {

		JavascriptExecutor js = (JavascriptExecutor) myBrowser;

		js.executeScript("window.scrollBy(0," + numScroll + ")", "");

	}

	public static String getTextOtherFrame(WebDriver myBrowser, String nameFrame, By target) {
		
		myBrowser.switchTo().frame(nameFrame);

		String texto = Action.getElementText(myBrowser, target);

		myBrowser.switchTo().defaultContent();

		return texto;
	}
 
	public static String getTextOtherWindow(WebDriver myBrowser, By target) {
				
		List<String> tab = new ArrayList<String>();
		tab.add(myBrowser.getWindowHandle());
		tab.add(myBrowser.getWindowHandle());
		
		myBrowser.switchTo().window(tab.get(1));
			
		String texto= Action.getElementText(myBrowser, target);
		
		myBrowser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		myBrowser.switchTo().window(tab.get(1));
		
		return texto;
	}  

	public static void verificarTexto(WebDriver myBrowser, String textoEncontrado, By target) {

		assertEquals(textoEncontrado, Action.getElementText(myBrowser, target));
	}

	public static List<WebElement> returnWebDriverElements(WebDriver myBrowser, String genericToSearch,
			String dataToSearch) {

		List<WebElement> listOfElements = myBrowser
				.findElements(By.xpath(String.format(genericToSearch, dataToSearch)));

		return listOfElements;
	}

	public static String cheapPrice(WebDriver myBrowser, String genericToSearch, String dataToSearch) {

		List<WebElement> listOfElements = myBrowser
				.findElements(By.xpath(String.format(genericToSearch, dataToSearch)));

		int menor = Integer.parseInt(listOfElements.get(3).getText().substring(0, 2));
		int index = 0;
		for (int i = 0; i < listOfElements.size() - 1; i++) {

			if (menor > Integer.parseInt(listOfElements.get(i).getText().substring(0, 2))) {

				menor = Integer.parseInt(listOfElements.get(i).getText().substring(0, 2));

				index = i;

			}
		}

		return String.valueOf(menor).concat(listOfElements.get(index).getText().substring(2, 5));
	}

	public static void genericButton(WebDriver myBrowser, String button, String typeButton) {
		Action.waitingIExplicit(myBrowser, By.xpath(String.format(typeButton, button)), 10);
		Action.clickElement(myBrowser, By.xpath(String.format(typeButton, button)));
	}

	public static void waitingIExplicit(WebDriver myBrowser, By target, int time) {

		WebDriverWait wait = new WebDriverWait(myBrowser, time);
		wait.until(ExpectedConditions.elementToBeClickable(target));

	}

	public static void sendPartialdataTable(WebDriver myBrowser, DataTable dataTable, String genericType,
			String genericComponent, String isScrollList, int index, int fin) {

		int positionElement = 0;
		List<List<String>> dataTravellers = dataTable.asLists(String.class);
		for (int i = index; i < fin; i++) {

			Action.returnWebDriverElements(myBrowser, genericType, genericComponent).get(positionElement).click();
			if (isScrollList.equalsIgnoreCase("si")) {
				Action.genericButton(myBrowser, dataTravellers.get(1).get(i), Constant.GENERIC_FORMAT_SPAN);

			} else {
				Action.returnWebDriverElements(myBrowser, genericType, genericComponent).get(positionElement)
						.sendKeys(dataTravellers.get(1).get(i));
				positionElement++;
			}

		}
	}

}
