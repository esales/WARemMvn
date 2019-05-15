import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CampusTest {
	private WebDriver driver;

	@BeforeEach
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}

	@AfterEach
	public void closeBrowser() {
		this.driver.quit();
	}

	@Test
	public void search() {
		driver.get("http://localhost:8080/WARemMvn");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		Select selectPerfil = (Select) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sctPerfil")));
		selectPerfil.selectByVisibleText("Administrador");
		driver.findElement(By.id("cmbLogin")).click();
		
		driver.findElement(By.id("itmCadCampus")).click();
		
		driver.findElement(By.id("itDescricao")).sendKeys("Novo Campus");
		driver.findElement(By.id("cmbCadastrar")).click();
		

	}
}