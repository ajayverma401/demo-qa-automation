package com.ajay.automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ajay.automation.base.BaseClass;

public class ScreenshotsUtils extends BaseClass {
	
	public static String captureScreenshot(String screenshotName) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); 
		String path = "./screenshots/" + screenshotName +"_"+ timeStamp + ".png";
		
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			Files.createDirectories(Paths.get("./screenshots/"));
//			Files.copy(src.toPath(), Paths.get(path));
			FileUtils.copyFile(src, new File(path));
		}
		
		catch(IOException e) {
			System.out.println("Failed to capture screenshot: " + e.getMessage());
			e.printStackTrace();
		}
		return path;	
	}
	
	public static byte[] captureScreenshotAsBytes() {
        try {
            // Take the screenshot and return it as bytes directly
            return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot as bytes: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
