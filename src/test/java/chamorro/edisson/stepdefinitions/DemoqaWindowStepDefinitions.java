package com.sophossolutions.stepdefinitions;

import com.sophossolutions.pages.PageDemoqaWindows;
import com.sophossolutions.utils.Constant;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class DemoqaWindowStepDefinitions {
	
	PageDemoqaWindows pageWindows;
	

	
	@When("obtengo los datos en los textbox de ambos windows")
	public void obtengoLosDatosEnLosTextboxDeAmbosWindows() {
	  pageWindows.getTextWindow(Constant.GENERIC_FORMAT_ID,Constant.GENERIC_FORMAT_ID,"tabButton","sampleHeading");  
	}
	
	@Then("Verifico que el mensaje sea {string} en demoqa")
	public void verificoQueElMensajeSeaEnDemoqa(String text) {
	   
	}
	
}
