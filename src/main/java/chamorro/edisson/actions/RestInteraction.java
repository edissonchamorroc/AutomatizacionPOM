package chamorro.edisson.actions;

import static org.junit.Assert.assertEquals;

import chamorro.edisson.utils.Constant;
import chamorro.edisson.utils.Convert;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

public class RestInteraction {

	private static String baseUrl;
	private static String getId = "";

	public static void setBaseUrl(String baseUrl) {
		RestInteraction.baseUrl = baseUrl;
	}

	public static void getUser(Integer id) {

		SerenityRest.given().auth().oauth2(Constant.TOKEN).contentType(ContentType.JSON)
				.get(baseUrl.concat(String.valueOf(id)));
		SerenityRest.lastResponse().prettyPeek();// borrar esta linea al final

	}

	public static void validateResponse(Integer numberCode) {
		Integer getStatusCode = SerenityRest.lastResponse().getStatusCode();
		assertEquals(numberCode, getStatusCode);

	}

	public static void post(String petition, DataTable dataTable) {
		SerenityRest.given().auth().oauth2(Constant.TOKEN).contentType(ContentType.JSON)
				.body(Convert.dataToMap(dataTable)).post(baseUrl);
		if (petition.equalsIgnoreCase("post"))
			getId = SerenityRest.lastResponse().getBody().jsonPath().getString(Constant.ID_USER);
		SerenityRest.lastResponse().prettyPeek();

	}

	public static void deleteUser(Integer id) {
		if (id != 0)
			getId = String.valueOf(id);
		SerenityRest.given().auth().oauth2(Constant.TOKEN).contentType(ContentType.JSON).delete(baseUrl.concat(getId));

	}

	public static void validateData(String nameUser, Integer idUser) {

		assertEquals(nameUser, SerenityRest.lastResponse().getBody().jsonPath().get(Constant.NAME_USER));
	}

}
