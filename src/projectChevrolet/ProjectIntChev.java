package projectChevrolet;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.Synthesizer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
              
//cambiar el nombre de los metodos
//cambiar la visibilidad (de private a protected)
//mover a la clase base todos los elementos que sean main.
     public class ProjectIntChev extends BaseTest {
    	 
	     public static void main(String[] args) {
			 
	       accederPagina("ttps://www.chevrolet.com.mx");
		   maximizarVentana();
	       buscarVehiculo("Aveo");
		   validarCaracteristicas("Equipamento"); 
		   validarPrecio("Precio") ;
		   validarContenidos("Contenidos") ;
		   cambiarTab() ;
	 }
}
	 		