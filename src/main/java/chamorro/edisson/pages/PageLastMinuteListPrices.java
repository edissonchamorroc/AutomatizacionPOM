package chamorro.edisson.pages;

import chamorro.edisson.actions.Action;
import chamorro.edisson.utils.Constant;

public class PageLastMinuteListPrices extends PageLastMinuteHome {
	
	public void chooseMenorValue() {
		
		String value = Action.cheapPrice(getDriver(), Constant.GENERIC_FORMAT_DIV_CLASS,
				"jwr-desktop-trip-card__sidebar-container");

		Action.returnWebDriverElements(getDriver(),
				"//div[@class='jwr-desktop-trip-card__sidebar-container' and contains(.,'%s')]//descendant::button",
				value).get(0).click();
		Action.genericButton(getDriver(), "Elegir Classic", Constant.GENERIC_FORMAT_TEXT);
	}  
} 
 