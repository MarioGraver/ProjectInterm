package projectChevrolet;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	protected static WebDriver driver;

	protected static void maximizarVentana() {

		driver.manage().window().maximize();
	}

	protected static void accederPagina(String pageTitle) {

		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("https://www.chevrolet.com.mx");
		WebDriverWait wait = new WebDriverWait(driver, 10);

		  String title = driver.getTitle();
		if (title.equals("Sitio oficial | Venta de autos, camionetas y más | Chevrolet Mex")) {
			System.out.println("el titulo de la pagina es correcto: Passed");
		} else {
			System.out.println("el titulo de la pagina not es correcto: failed");
		}
	}

	protected static void buscarVehiculo(String car) {
		
		driver.findElement(By.xpath("(//span[@class='q-nav-primary-link-label'])[1]")).click();
		driver.findElement(By.xpath(
				"//img[@src='/content/dam/chevrolet/na/mx/es/vdc-collections/2019/cars/aveo/aveo/01-images/2018-aveo-jellybean.jpg?imwidth=321']"))
				.click();
	}

	protected static void validarCaracteristicas(String Equipamento) {
	
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement element = wait1.until(ExpectedConditions
				.presenceOfElementLocated((By.xpath("(//a[contains(@href,'/autos/aveo-auto-sedan')])[7]"))));
		WebElement elemnt = driver.findElement(By.xpath("(//a[contains(@href,'/autos/aveo-auto-sedan')])[7]"));

		if (elemnt.getText().equals("Precios")) {

			System.out.println("Text del menu es correcto : " + elemnt.getText());
		} else {
			System.out.println("Text del menu es incorrecto: " + elemnt.getText());
		}
		WebDriverWait wait2 = new WebDriverWait(driver, 10);

		WebElement element1 = wait2.until(ExpectedConditions
				.presenceOfElementLocated((By.xpath("(//a[contains(@href,'/autos/aveo-auto-sedan')])[6]"))));
		WebElement elemnt1 = driver.findElement(By.xpath("(//a[contains(@href,'/autos/aveo-auto-sedan')])[6]"));

		if (elemnt1.getText().equals("Equipamiento")) {

			System.out.println("Text del menu es correcto : " + elemnt1.getText());
		} else {
			System.out.println("Text del menu es incorrecto: " + elemnt1.getText());
		}

		WebDriverWait wait3 = new WebDriverWait(driver, 10);

		WebElement element2 = wait3.until(ExpectedConditions
				.presenceOfElementLocated((By.xpath("(//a[contains(@href,'/autos/aveo-auto-sedan')])[8]"))));
		WebElement elemnt2 = driver.findElement(By.xpath("(//a[contains(@href,'/autos/aveo-auto-sedan')])[8]"));

		if (elemnt2.getText().equals("Accesorios")) {

			System.out.println("Text del menu es correcto : " + elemnt2.getText());
		} else {
			System.out.println("Text del menu es incorrecto: " + elemnt2.getText());
		}
		WebDriverWait wait4 = new WebDriverWait(driver, 10);

		WebElement element3 = wait4.until(ExpectedConditions
				.presenceOfElementLocated((By.xpath("(//a[contains(@href,'/autos/aveo-auto-sedan')])[9]"))));
		WebElement elemnt3 = driver.findElement(By.xpath("(//a[contains(@href,'/autos/aveo-auto-sedan')])[9]"));

		if (elemnt3.getText().equals("Cotiza")) {

			System.out.println("Text del menu es correcto : " + elemnt3.getText());
		} else {
			System.out.println("Text del menu es incorrecto: " + elemnt3.getText());
		}
		String title1 = driver.getTitle();
		if (title1.equals("Aveo 2019 | El auto sedán más popular de México | Chevrolet Mex")) {
			System.out.println("el titulo es correcto: Passed");
		} else {
			System.out.println("el tutilo de la pagina es incorrecto: Failed");
		}
	}

	protected static void validarPrecio(String Precio) {
		WebDriverWait wait5 = new WebDriverWait(driver, 5);

		WebElement precio1 = wait5.until(ExpectedConditions.presenceOfElementLocated(
				(By.xpath("(//span[@class='show-disclosure q-mod q-mod-rte-disclosure q-rte-disclosure'])[1]"))));
		{
			if (precio1.getText().equals("$196,400†")) {
				System.out.println("El Precio es correcto:  " + precio1.getText());
			} else {
				System.out.println("El Precio es incorrecto: " + precio1.getText());
			}
		}
	}

	protected static void validarContenidos(String Contenidos) {
		WebDriverWait wait6 = new WebDriverWait(driver, 5);

		WebElement contenido = wait6
				.until(ExpectedConditions.presenceOfElementLocated((By.xpath("(//div[@class='q-text q-body1'])[1]"))));
		{
			if (contenido.getText().equals(
					"Chevrolet Aveo®, es y seguirá siendo el favorito de todos gracias a su increíble look, equipamiento mejorado y gran rendimiento de combustible que te llevará a donde sea que quieras con todo el estilo que buscabas.")) {
				System.out.println("El Contenido es correcto: " + contenido.getText());
			} else {
				System.out.println("El Contenido es incorrecto" + contenido.getText());
			}
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)", "");

	}

	protected static void cambiarTab() {

		WebElement DistLink = driver.findElement(By.linkText("Distribuidores"));
		DistLink.click();
		ArrayList<String> windowIds = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Number of windows: " + windowIds.size());

		for (String windowId : driver.getWindowHandles()) {
			driver.switchTo().window(windowId);
		}

	}}

	