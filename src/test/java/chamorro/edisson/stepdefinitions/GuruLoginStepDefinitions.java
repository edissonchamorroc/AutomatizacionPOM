package com.sophossolutions.stepdefinitions;

import com.sophossolutions.pages.PageGuruLogin;

import com.sophossolutions.pages.PageGuruRegister;

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
