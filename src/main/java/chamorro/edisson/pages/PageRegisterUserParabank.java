package chamorro.edisson.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;
import chamorro.edisson.utils.Constant;
import io.cucumber.datatable.DataTable;

public class PageRegisterUserParabank extends PageNewAccountParabank {
	

	public void enviarDatos(DataTable dataTable) {
		Action.sendList(getDriver(),dataTable,Constant.GENERIC_FORMAT_ID,11);
		this.btnGeneric("Register");
	} 
 
	public void verificarNewUser() {
		String texto="Your account was created successfully. You are now logged in.";
		By textoRegistro = By.xpath(String.format("//*[text()='%s']", texto)); 
		assertEquals(texto, Action.getElementText(getDriver(),textoRegistro ));
	}  
} 



