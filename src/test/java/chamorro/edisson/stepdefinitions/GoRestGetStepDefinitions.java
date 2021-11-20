package chamorro.edisson.stepdefinitions;

import chamorro.edisson.actions.RestInteraction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoRestGetStepDefinitions {
	@Given("Se establece la base url {string}")
	public void seEstableceLaBaseUrl(String url) {
		RestInteraction.setBaseUrl(url);
	}

	@When("Consulto con id {int}")
	public void consultoConId(Integer idUser) {
		RestInteraction.getUser(idUser);
	}

	@Then("Verifico que el codigo de respuesta sea {int}")
	public void verificoQueElCodigoDeRespuestaSea(Integer statusCode) {
		RestInteraction.validateResponse(statusCode);
	} 

}
