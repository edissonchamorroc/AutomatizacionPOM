package chamorro.edisson.utils;

import java.util.Map;

import io.cucumber.datatable.DataTable;

public class Convert {

	public static Map<String,String> dataToMap(DataTable dataTable) {
		return dataTable.asMap(String.class, String.class); 
	}
	
}
