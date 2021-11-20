package chamorro.edisson.stepdefinitions;

import chamorro.edisson.pages.PageGuruRegister;
import io.cucumber.java.en.When;

public class GuruRegisterStepDefinitions {
	
	PageGuruRegister register;
	
	@When("Ingreso a opcion {string}")
	public void ingresoAOpcion(String nameOption) {
		register.btnOption(nameOption); 
	}
	
	@When("Inserto los datos de la tabla")
	public void insertoLosDatosDeLaTabla(io.cucumber.datatable.DataTable dataTable) {
		register.fillData(dataTable);
		register.submit("Submit");
	}
	 
}
