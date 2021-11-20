package chamorro.edisson.stepdefinitions;

import chamorro.edisson.actions.RestInteraction;
import io.cucumber.java.en.Then;

public class GoRestConsultUserStepDefinitions {


	@Then("Verifico que nombre {string} corresponda al de usuario {int}")
	public void verificoQueNombreCorrespondaAlDeUsuario(String nameUser, Integer idUser) {
		RestInteraction.validateData(nameUser,idUser);
	}
}
