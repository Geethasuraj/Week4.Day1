package week4.day1assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.switchTo().frame("frame1");
		driver.findElementByXPath("//b[@id='topic']/following::input").sendKeys("Frame");
		driver.switchTo().frame("frame3");
		driver.findElementByXPath("//input[@type='checkbox']").click();
		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame2");
		WebElement text = driver.findElementById("animals");
		Select drpdwn = new Select(text);
		drpdwn.selectByVisibleText("Baby Cat");

	}

}
