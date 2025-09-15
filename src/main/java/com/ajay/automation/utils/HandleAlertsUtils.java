package com.ajay.automation.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import com.ajay.automation.base.BaseClass;

public class HandleAlertsUtils extends WaitUtils {
	
//	 static WaitUtils waitUtils = new WaitUtils(Integer.parseInt(ConfiReaderUtils.get("explicitWait")));
	 public HandleAlertsUtils() {
		super(Integer.parseInt(ConfiReaderUtils.get("explicitWait")));
	} 
	 
	 /* Agar parent class me parameterised constructor define hai aur default constructor nahi hai, to compiler ka auto super(); call fail ho jaata hai.

Isliye tumhe super(args) likhna padta hai, warna error aata hai. */
	
	public static Alert switchToAlert() {
//		return BaseClass.getDriver().switchTo().alert();
		return getWait().until(ExpectedConditions.alertIsPresent());
		}
	
	public static String getAlertText() {
		return switchToAlert().getText();
	}
	
	public static void acceptAlert() {
		switchToAlert().accept();
	}
	
	public static void dismissAlert() {
		switchToAlert().dismiss();
	}

	public static void sendTextToAlert(String text) {
		switchToAlert().sendKeys(text);
	}
}
