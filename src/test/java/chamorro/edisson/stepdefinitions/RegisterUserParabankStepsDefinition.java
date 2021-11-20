package com.sophossolutions.stepdefinitions;

import com.sophossolutions.pages.PageLoginParabank;
import com.sophossolutions.pages.PageGuruRegister;
import com.sophossolutions.pages.PageRegisterUserParabank;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterUserParabankStepsDefinition {
	
	PageLoginParabank goToUrl;
	PageRegisterUserParabank register;

	@Given("deseo dar click a boton {string}")
	public void deseoDarClickABoton(String nameBtn) {
		register.clicPage(nameBtn); 
	}

	@When("Ingresando para cada campo el dato correspondiente")
	public void ingresandoParaCadaCampoElDatoCorrespondiente(DataTable dataTable) {
		register.enviarDatos(dataTable);
	}

	@Then("verfico si se registra usuario correctamente")
	public void verficoSiSeRegistraUsuarioCorrectamente() {
		register.verificarNewUser();
	}
}

