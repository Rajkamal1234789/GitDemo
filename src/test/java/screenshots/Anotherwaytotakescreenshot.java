package screenshots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Anotherwaytotakescreenshot {

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
		
		getscreenshot(email,"email2");
		getscreenshot(password,"password2");
		getscreenshot(login,"login2");
		getscreenshot(passwordlink,"passwordlink2");

	}
	public static void getscreenshot(WebElement element, String filename) throws Exception {
		TakesScreenshot ts=(TakesScreenshot)element;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/"+ filename +".png"));

		
	}

}
