package com.qa.citizen.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("aws")
public class SeleniumTests {

	private RemoteWebDriver driver;
		
	private WebDriverWait wait;

	@BeforeEach
	void setup() {
		System.setProperty("webdriver.chrome.driver","/home/ubuntu/FinalProjectRepo/backend/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		
		this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}
	
	@Test
	void searchCitizenBiography() {
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		
		this.driver.get("http://54.74.11.52/");
		
		WebElement addForenames = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div[1]/label/input"));
		WebElement addSurname = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div[2]/label/input"));
		WebElement addDateOfBirth = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[3]/div[1]/label/input"));

		WebElement searchCitizen = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[5]/button"));
		
		addForenames.sendKeys("Julie");
		addSurname.sendKeys("Willis");
		addDateOfBirth.sendKeys("1944-02-24");
		
		searchCitizen.sendKeys(Keys.ENTER);
		
		WebElement selectJulie = this.driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/a/button"));
		
		selectJulie.click();
		
		WebElement BiographyData = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/h4")));
		
		Assertions.assertTrue(BiographyData.getText().contains("Citizen Name: Julie Willis"));
	}
	
	@Test
	void searchCitizenAssociates() {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		
		this.driver.get("http://54.74.11.52/");
		
		WebElement addForenames = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div[1]/label/input"));
		WebElement addSurname = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div[2]/label/input"));
		WebElement addDateOfBirth = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[3]/div[1]/label/input"));

		WebElement searchCitizen = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[5]/button"));
		
		addForenames.sendKeys("Julie");
		addSurname.sendKeys("Willis");
		addDateOfBirth.sendKeys("1944-02-24");
		
		searchCitizen.sendKeys(Keys.ENTER);
		
		WebElement selectJulie = this.driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/a/button"));
		
		selectJulie.click();
		
		WebElement selectAssociates = this.driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/a[3]/button"));
		
		selectAssociates.click();

		WebElement AssociatesData = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td[1]")));
		
		Assertions.assertTrue(AssociatesData.getText().contains("Jordan Robert Paterson"));
	}
	
	@Test
	void searchCitizenFinancials() {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		
		this.driver.get("http://54.74.11.52/");
		
		WebElement addForenames = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div[1]/label/input"));
		WebElement addSurname = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div[2]/label/input"));
		WebElement addDateOfBirth = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[3]/div[1]/label/input"));

		WebElement searchCitizen = this.driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[5]/button"));
		
		addForenames.sendKeys("Julie");
		addSurname.sendKeys("Willis");
		addDateOfBirth.sendKeys("1944-02-24");
		
		searchCitizen.sendKeys(Keys.ENTER);
		
		WebElement selectJulie = this.driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/a/button"));
		
		selectJulie.click();
		
		WebElement selectFinancials = this.driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/a[4]/button"));
		
		selectFinancials.click();

		WebElement FinancialData = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[3]")));
		
		Assertions.assertTrue(FinancialData.getText().contains("sort code: 58-15-51"));
	}
	
	
	@AfterEach
	void teardown() {
		driver.quit();
	}
}

