package chamorro.edisson.stepdefinitions;

import chamorro.edisson.pages.PageGuruLogin;
import chamorro.edisson.pages.PageGuruRegister;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuruLoginStepDefinitions {

	PageGuruLogin pageIndex;
	PageGuruRegister pageRegiste;

	@Given("Dado que estoy en la url {string}")
	public void dadoQueEstoyEnLaUrl(String url) {
		pageIndex.navegateTo(url);
	}

	@When("Ingreso datos usuario")
	public void ingresoDatosUsuario(DataTable dataTable) {
		pageIndex.logear(dataTable);
	}

	@Then("Verifico el mensaje {string}")
	public void verificoElMensaje(String message) {
		pageRegiste.verificarRegistro(message);
	}

}
