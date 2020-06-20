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

public class Screenshotofgroupofelements {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		WebElement element=driver.findElement(By.id("hs-login"));
		
		File src=element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/groupelement.png"));
		driver.close();

	}

}
