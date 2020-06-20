package getRect;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getrect {

	public static void main(String[] args) {
		//selenium4
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		WebElement email=driver.findElement(By.id("email"));
	Rectangle rect=	email.getRect();
	System.out.println(rect.getHeight());
	System.out.println(rect.getWidth());
	System.out.println(rect.getX());
	System.out.println(rect.getY());
		
		

	}

}
