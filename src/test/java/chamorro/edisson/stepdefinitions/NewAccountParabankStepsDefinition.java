package chamorro.edisson.stepdefinitions;

import chamorro.edisson.pages.PageAccountOverviewParabank;
import chamorro.edisson.pages.PageLoginParabank;
import chamorro.edisson.pages.PageNewAccountParabank;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewAccountParabankStepsDefinition {
	PageLoginParabank loginParabank;
	PageNewAccountParabank newAccount;
	PageAccountOverviewParabank overView;

	
	@Given("Que ingreso a la pestana\"Open New Account\"")
	public void queIngresoALaPestanaOpenNewAccount() {
		newAccount.clicPage("Open New Account");
	}

	@When("Creo una nueva cuenta dando click en el boton {string}")
	public void creoUnaNuevaCuentaDandoClickEnElBoton(String nameBoton) {
		newAccount.creacionCuenta(nameBoton);
	}

	@Then("Verifico la creacion de nueva cuenta en {string}")
	public void verificoLaCreacionDeNuevaCuentaEn(String namePage) {

		overView.verificarNewAccount(newAccount.codigo(), namePage);
	}
}

