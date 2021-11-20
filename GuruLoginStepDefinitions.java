package chamorro.edisson.stepdefinitions;

import java.util.Map;

import chamorro.edisson.pages.PageGuruLogin;
import chamorro.edisson.pages.PageGuruRegister;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuruLoginStepDefinitions {

	PageGuruLogin pageIndex;
	PageGuruRegister pageRegiste;

	@Given("Dado que estoy en la url:{string}")
	public void dadoQueEstoyEnLaUrl(String url) {
		pageIndex.navegateTo(url);
	}
	
	
	@When("Ingreso datos usuario")
	public void ingresoDatosUsuario(Map<String,String> userData) {
		pageIndex.logear(userData);
	}

	@Then("Verifico el mensaje {string}")
	public void verificoElMensaje(String message) {
		pageRegiste.verificarRegistro(message);
	}

}
