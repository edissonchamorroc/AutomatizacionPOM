package com.sophossolutions.stepdefinitions;

import com.sophossolutions.actions.RestInteraction;
import com.sophossolutions.utils.Constant;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoRestDeleteUserStepDefinitions {

	@When("Elimino usuario con {int}")
	public void eliminoUsuarioCon(Integer id) {
		RestInteraction.deleteUser(id);
	}

}
