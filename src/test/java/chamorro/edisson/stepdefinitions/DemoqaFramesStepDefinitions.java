package com.sophossolutions.stepdefinitions;

import com.sophossolutions.pages.PageFramesDemoqa;
import com.sophossolutions.pages.PageHomeDemoqa;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoqaFramesStepDefinitions {

	PageHomeDemoqa homePage;
	PageFramesDemoqa framePage;

	@Given("Acciono la opcion {string}")
	public void accionoLaOpcion(String nameOption) {
		homePage.clickOption(nameOption);
	}
 
	@Given("ingreso a la ventana {string}")
	public void ingresoALaVentana(String nameWindow) {
		framePage.clickOption(nameWindow);
	}

	@When("obtengo los datos en los textbox de la ventana Frame")
	public void obtengoLosDatosEnLosTextboxDeLaVentanaFrame() {
		framePage.intoTextBoxData();
	}

	@Then("Verifico que el mensaje sea {string}")
	public void verificoQueElMensajeSea(String message) {
		framePage.verificarTexto(message);
	}
}
