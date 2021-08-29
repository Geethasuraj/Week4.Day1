package week4.day1assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Enter UserName and Password Using Id Locator
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		driver.findElementByClassName("decorativeSubmit").click();

		// Click on CRM/SFA Link
		driver.findElementByLinkText("CRM/SFA").click();

		// Click on contacts Button
		driver.findElementByLinkText("Contacts").click();

		// Click on Merge Contacts using Xpath Locator
		driver.findElementByXPath("//a[text()='Merge Contacts']").click();

		// Click on Widget of From Contact
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();

		// Click on First Resulting Contact
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElementByXPath("(//a[@class='linktext'])[1]").click();
		driver.switchTo().window(windowHandlesList.get(0));

		// Click on Widget of To Contact
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();

		// Click on Second Resulting Contact
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		driver.switchTo().window(windowHandlesList1.get(1));
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a").click();
		driver.switchTo().window(windowHandlesList1.get(0));

		// Click on Merge button using Xpath Locator

		driver.findElementByXPath("//a[text()='Merge']").click();

		// Accept the Alert
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		alert.accept();

		// Verify the title of the page
		String title = driver.getTitle();
		System.out.println(title);

	}

}
