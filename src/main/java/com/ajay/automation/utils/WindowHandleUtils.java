package com.ajay.automation.utils;

import java.util.Set;

import com.ajay.automation.base.BaseClass;

public class WindowHandleUtils extends BaseClass {

	public static void switchToChild() {

		String parentWindow = getDriver().getWindowHandle();

		Set<String> allWindows = getDriver().getWindowHandles();

		for(String window : allWindows) {

			if(!window.contains(parentWindow)) {
				getDriver().switchTo().window(window);
				break;

			}

		}

	}

	public static void switchBackToParent(String parentWindow) {
		getDriver().switchTo().window(parentWindow);
	}

	public static void closeChildAndSwitchBack(String parentWindow) {
		getDriver().close();
		getDriver().switchTo().window(parentWindow);

	}

}
