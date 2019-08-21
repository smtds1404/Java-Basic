
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptAlert {

	public static void main(String[] args) throws IOException, InterruptedException {
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\AE13127\\Desktop\\Selenium
		// docs\\Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://axa.us.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// Actions action=new Actions (driver);
		driver.findElement(By.id("header-desktop-login")).click();
		// action.moveToElement(driver.findElement(By.id("loginId"))).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.id("loginId")).sendKeys("nblife17");
		driver.findElement(By.id("loginPassword")).sendKeys("Life1234");
		Thread.sleep(3000);
		driver.findElement(By.id("panel-desktop-login")).click();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("C:<\\Users\\AE13127\\Desktop\\Selenium docs\\Jars\\Screenshots\\screen1.png>"));

		driver.quit();
		
	}

}