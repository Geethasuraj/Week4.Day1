package week4.day1assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev113545.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().frame(0);
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("w6hnF2FRhwLC");

		// Click Login
		driver.findElementById("sysverb_login").click();

		// Search “incident “ Filter Navigator
		driver.findElementById("filter").sendKeys("incident", Keys.ENTER);

		// Click “All”
		driver.findElementByXPath("(//div[text()='All'])[2]").click();

		// Click New button
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//button[@type='submit']").click();

		// select a value for caller and Enter value for short_description

		driver.findElementById("incident.short_description").sendKeys("New Incident");

		driver.findElementByXPath("//button[@id='lookup.incident.caller_id']").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowhandlesList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowhandlesList.get(1));

		driver.findElementByXPath("(//a[@class='glide_ref_item_link'])[1]").click();
		driver.switchTo().window(windowhandlesList.get(0));
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");

		// Read the incident number and save it a variable
		String value = driver.findElementById("incident.number").getAttribute("value");
		System.out.println(value);

		// click on Submit button
		driver.findElementById("sysverb_insert").click();

		// search the same incident number in the next search screen as below
		driver.findElementByXPath("//input[@class='form-control']").sendKeys(value, Keys.ENTER);

		// verify the incident is created successful
		String text = driver.findElementByXPath("(//td[@class='vt'])[1]").getText();

		if (value.equals(text)) {
			System.out.println("Incident is created");
		} else {
			System.out.println("Incident not created");
		}

	}

}
