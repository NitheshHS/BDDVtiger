package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.messages.internal.com.google.common.io.Files;

public class WebDriverUtility {

	public static void getScreenshot(WebDriver driver,String screenshotName) {
		TakesScreenshot screenshot=(TakesScreenshot)driver;

		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(FilePath.SCREENSHOT_FOLDER+screenshotName+".PNG");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			System.out.println("Screenshot not copied to destination: "+dest);
		}
	}

	public static byte[] getScreenshotInBytes(WebDriver driver) {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		byte[] src=screenshot.getScreenshotAs(OutputType.BYTES);
		return src;
	}
	
	public static void selectDropDown(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public static void selectDropDown(WebElement element,String visibleText) {
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}

}
