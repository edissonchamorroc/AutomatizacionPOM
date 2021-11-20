package chamorro.edisson.stepdefinitions;

import chamorro.edisson.actions.RestInteraction;
import io.cucumber.java.en.When;

public class GoRestDeleteUserStepDefinitions {

	@When("Elimino usuario con {int}")
	public void eliminoUsuarioCon(Integer id) {
		RestInteraction.deleteUser(id);
	}

}
