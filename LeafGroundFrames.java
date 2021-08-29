package week4.day1assignment;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrames {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Take the the screenshot of the click me button of first frame
		WebElement click = driver.findElementByXPath("(//div[@id='wrapframe'])[1]/iframe");
		driver.switchTo().frame(click);
		// WebElement shot = driver.findElementById("Click");

		WebElement shot = driver.findElementById("Click");
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/seats.png");
		FileUtils.copyFile(src, dst);
		driver.switchTo().defaultContent();
		// driver.switchTo().defaultContent();
		// Find the number of frames
		// find the Elements by tagname - iframe
		// Store it in a list
		List<WebElement> noOfFrame = driver.findElements(By.tagName("iframe"));
		// Get the size of the list. (This gives the count of the frames visible to the
		// main page)

		System.out.println("Number of Frames are: " + noOfFrame.size());

	}

}
