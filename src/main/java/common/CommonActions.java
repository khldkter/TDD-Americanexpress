package common;

import static org.testng.Assert.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import reporting.Logs;

import static org.testng.Assert.fail;



public class CommonActions {
	public static void click(WebElement element) {
		try {
			element.click();
			Logs.log(element + " has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Logs.log("ELEMENT NOT FOUND" + element);
			fail();
		}
		
	}
	public static void input(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Logs.log(value + "has been passed to" + element);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Logs.log("ELEMENT NOT FOUND" + element);
			fail();
		}
	}
	public static boolean isDisplayed(WebElement element) {
		if(element.isDisplayed()) {
			Logs.log(element + " <--- is VISIBLE");
			return true;
		}else {
			Logs.log(element + " <--- NOT VISIBLE");
			return false;
		}
	}
	public static boolean isPresent(WebElement element) {
		try {
			element.isEnabled();
			Logs.log(element + " <--- has been PRESENT");
			return true;
		}catch(NoSuchElementException | NullPointerException e) {
			Logs.log("ELEMENT NOT FOUND -->" + element);
			return false;
		}
	}
}
	
	
	

	