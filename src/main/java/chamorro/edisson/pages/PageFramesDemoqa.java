package chamorro.edisson.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import chamorro.edisson.actions.Action;

public class PageFramesDemoqa extends PageHomeDemoqa {

	String texto1, texto2;

	public void intoTextBoxData() {
		By frame = By.xpath("//*[@id='sampleHeading']");
		texto1 = Action.getTextOtherFrame(getDriver(), "frame1", frame);
		texto2 = Action.getTextOtherFrame(getDriver(), "frame2", frame);

	}

	public void verificarTexto(String mensaje) {

		assertEquals(mensaje, this.texto1);
		assertEquals(mensaje, this.texto2);

	}

}
