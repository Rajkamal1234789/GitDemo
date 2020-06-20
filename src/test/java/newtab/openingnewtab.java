package newtab;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openingnewtab {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://www.facebook.com");
		Set<String>handles=driver.getWindowHandles();
		List<String>ls=new ArrayList<String>(handles);
		String parentid=ls.get(0);
		String childid=ls.get(1);
		System.out.println( "new tab title is:"+driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentid);
		System.out.println("after switching to parentid:"+driver.getTitle());
		
		
		
		
		

	}

}
