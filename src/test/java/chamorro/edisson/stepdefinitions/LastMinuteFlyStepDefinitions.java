package chamorro.edisson.stepdefinitions;

import chamorro.edisson.pages.PageLastMinuteDataCreditCard;
import chamorro.edisson.pages.PageLastMinuteDataTravellers;
import chamorro.edisson.pages.PageLastMinuteHome;
import chamorro.edisson.pages.PageLastMinuteListPrices;
import chamorro.edisson.utils.Constant;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LastMinuteFlyStepDefinitions {

	PageLastMinuteHome home;
	PageLastMinuteListPrices listPrices;
	PageLastMinuteDataTravellers dataTravellers;
	PageLastMinuteDataCreditCard dataCreditCard;

	@Given("Ingreso a la pestana {string}")
	public void ingresoALaPestana(String nameButton) {
		home.choiceOption(nameButton); 

	}

	@When("Ingreso datos de ciudad")
	public void ingresoDatosDeCiudad(DataTable dataTable) {
		home.sendDataTravel(dataTable, Constant.GENERIC_INPUT_TYPE, "text", Constant.GENERIC_FORMAT_SPAN, "id");
		listPrices.chooseMenorValue();

	}

	@When("Ingreso datos de usuario")
	public void ingresoDatosDeUsuario(DataTable dataTable) { 
		dataTravellers.sendDataTravelers(dataTable);

	}

	@When("Ingreso datos de reserva")
	public void ingresoDatosDeReserva(DataTable dataTable) {

		dataTravellers.sendDataReserved(dataTable); 
		 
	}   

	@When("Ingreso datos de pago")
	public void ingresoDatosDePago(DataTable dataTable) {
		dataCreditCard.payData(dataTable);
	}

	@Then("Verifico mensaje de reserva {string}")
	public void verificoMensajeDeReserva(String message) {

	}
}
