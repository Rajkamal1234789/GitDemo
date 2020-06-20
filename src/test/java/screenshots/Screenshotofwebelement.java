package screenshots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshotofwebelement {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		driver.get("https://app.hubspot.com/login");
		
		WebElement email=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement login=driver.findElement(By.id("loginBtn"));
		email.sendKeys("rajkamal mamidala");
		password.sendKeys("omnamahshivaya");
		WebElement passwordlink=driver.findElement(By.partialLinkText("Forgot my password"));
		screenshot(passwordlink,"passwordlink");
		screenshot(email,"email");
		screenshot(password,"password");
		screenshot(login,"login");
		
		driver.close();

	}


public static void screenshot(WebElement element, String filename) throws Exception {
	File src=element.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("./Screenshots/"+filename+".png"));
}
}
