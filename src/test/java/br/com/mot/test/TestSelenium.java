package br.com.mot.test;
import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSelenium {
	
	// Declarando o driver do Selenium WebDriver
	private WebDriver driver;
	// Pega o seu Sistema Operacional (Windows, Linux, Mac) 
	private static String OS = System.getProperty("os.name").toUpperCase();
	// Pega o diretório onde está armazenado este projeto e o driver do Google Chrome
	String currentDirectory = System.getProperty("user.dir") + File.separator + "drivers" + File.separator;
	
	
	@Before
	public void inicioTest() {
		
		// Valida o Sistema Operacional (Linux ou Windows)
		 if (OS.equalsIgnoreCase("LINUX"))
			 System.setProperty("webdriver.chrome.driver", currentDirectory + "chromedriver");
		 else if (OS.equalsIgnoreCase("WINDOWS"))
			 System.setProperty("webdriver.chrome.driver", currentDirectory + "chromedriver.exe");
		 
		
		// Inicia uma instância do ChromeDriver
		driver = new ChromeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		// Navigate to Google
		driver.get("http://automationpractice.com/index.php");
		
	}
	
	
	
	
	@Test 
	public void realizaTest() throws InterruptedException {
		// Mapeando o link Sign In
		WebElement linkSignIn = driver.findElement(By.partialLinkText("Sign in"));
		// Clicando no link Sign In
		linkSignIn.click();
		
		// Mapeando o input de E-mail address
		WebElement inputEmailAddress = driver.findElement(By.id("email_create"));
		// Informando E-mail address
		inputEmailAddress.sendKeys("test_automation_java" + (int) (Math.random() * 100) + "@mailinator.com");
		
		// Mapeando o botão Create an account
		WebElement btnCreatAnAccount = driver.findElement(By.id("SubmitCreate"));
		// Clicando no botão Create an account
		btnCreatAnAccount.click();
		
		
		/*
		 * PREENCHENDO A ÁREA - YOUR PERSONAL INFORMATION
		 */
		
		// Esperando a tela carregar por 5 segundos
		Thread.sleep(5000);
		
		// Mapeando o radiobutton Mr.
		WebElement radioMr = driver.findElement(By.id("id_gender1"));
		// Clicando no radiobutton Mr.
		radioMr.click();
		
		// Mapeando o input First ame
		WebElement inputCustomerFirstName = driver.findElement(By.name("customer_firstname"));
		// Informando o First Name e usando a tecla TAB
		inputCustomerFirstName.sendKeys("Java" + Keys.TAB);
		
		// Mapeando o input Last name
		WebElement inputCustomerLastName = driver.findElement(By.xpath(".//input[@id='customer_lastname']"));
		// Informando o Last Name	
		inputCustomerLastName.sendKeys("MOT");
		
		// Mapeando o input Password
		WebElement inputPassword = driver.findElement(By.id("passwd"));
		// Informando Password
		inputPassword.sendKeys("EuToNoMOT13");
		
		// Mapeando o combobox Day of Birth
		Select comboDay = new Select( driver.findElement(By.id("days")) );
		// Selecionando do dia do MOT (27)
		comboDay.selectByVisibleText("27  ");
		
		// Mapeando o combobox Month of Birth
		Select comboMonth = new Select( driver.findElement(By.id("months")) );
		// Selecionando o mês do MOT (August)
		comboMonth.selectByVisibleText("August ");
		
		// Mapeando o combobox Year of Birth
		Select comboYear = new Select( driver.findElement(By.id("years")) );
		// Selecionando o ano do MOT (2019)
		comboYear.selectByVisibleText("1984  ");
		
		// Mapeando o checkbox Sign up for our newsletter!
		WebElement checkSignIn = driver.findElement(By.id("newsletter"));
		// Clicando no checkbox
		checkSignIn.click();
		
		
		/*
		 * PREENCHENDO A ÁREA - YOUR ADDRESS
		 */
		// Mapeando o input Address
		WebElement inputAddress = driver.findElement(By.id("address1"));
		// Informando input Address
		inputAddress.sendKeys("Rua do Teste");
		
		// Mapeando o input City
		WebElement inputCity = driver.findElement(By.id("city"));
		// Informando a cidade
		inputCity.sendKeys("Cidade dos Testes");
		
		// Mapeando o combobox State
		Select comboState = new Select( driver.findElement(By.id("id_state")) );
		// Selecionando o State por índice
		comboState.selectByIndex(5);
				
		// Mapeando o input Zip/Postal Code
		WebElement inputZipPostalCode = driver.findElement(By.id("postcode"));
		// Informando o input Zip/Postal Code
		inputZipPostalCode.sendKeys("75315");
		
		// Mapeando o textarea Additional information
		WebElement inputInfo = driver.findElement(By.tagName("textarea"));
		// Informando textarea Additional information
		inputInfo.sendKeys("Filósofo de comentários diz: "
				+ "Para que serve tantos códigos? Se a vida não é programada e as melhores coisas não tem lógica." + Keys.TAB);
				
		// Mapeando o input Mobile phone
		WebElement inputMobilePhone = driver.findElement(By.id("phone_mobile"));
		// Informando o celular
		inputMobilePhone.sendKeys("98765-4321");
		
		// Mapeando o input Assign an address alias for future reference
		WebElement inputAlias = driver.findElement(By.name("alias"));
		// Limpando o input antes de informar um Alias
		inputAlias.clear();
		// Informando Alias
		inputAlias.sendKeys("MOT13 - Selenium e Java");
		
		// Mapeando o botão REGISTER
		WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		// Clicando no botão REGISTER
		btnRegister.click();
		
	}
	
	
	
	@After  
	public void finalizaTeste() throws InterruptedException {
		// Esperando 5 segundos
		Thread.sleep(5000);
		
		// Fechando o navegador
		driver.quit();	
	}
	
}
