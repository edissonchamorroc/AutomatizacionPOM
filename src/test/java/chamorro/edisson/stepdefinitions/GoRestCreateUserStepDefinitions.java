package com.sophossolutions.stepdefinitions;

import com.sophossolutions.actions.RestInteraction;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class GoRestCreateUserStepDefinitions {

	@When("Realizo  un {string}")
	public void realizoUn(String string, DataTable dataTable) {
		RestInteraction.post(string, dataTable);
	}
}
