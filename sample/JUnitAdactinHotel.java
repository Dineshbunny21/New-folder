package org.sample;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JUnitAdactinHotel extends BaseClass {

	static WebDriver driver;

	@BeforeClass
	public static void initialLaunch() throws InterruptedException {
	getDriver();
	loadUrl("https://adactinhotelapp.com/");
	waitUrl();
	}
	
	@Test
	public void login() throws IOException {
		
		type(findElementById("username"), getData("Data", 1, 0));
		
		type(findElementById("password"), getData("Data", 1, 1));
		
		click(findElementById("login"));
		
		String text2 = getText(findElementByxpath("//td[@class='login_title']"));
		Assert.assertEquals("verify Search Hotel", "Search Hotel (Fields marked with Red asterix (*) are mandatory)",text2);
		System.out.println(text2);

		selectOptionsByText(findElementById("location"), getData("Data", 1, 2));
	
		selectOptionsByText(findElementById("hotels"), getData("Data", 1, 3));
		
		selectOptionsByText( findElementById("room_type"), getData("Data", 1, 4));
		
		selectOptionsByText(findElementById("room_nos"), getData("Data", 1, 5));
		
		selectOptionsByText(findElementById("adult_room"), getData("Data", 1, 6));
		
		selectOptionsByText(findElementByName("child_room"), getData("Data", 1, 7));
		
		click(findElementById("Submit"));
		
		String text3 = getText(findElementByxpath("//td[@class='login_title']"));
		Assert.assertEquals("verify select hotel","Select Hotel", text3);
		System.out.println(text3);
		
		click( findElementById("radiobutton_0"));

		click(findElementByName("continue"));
		
		String text4 = getText(findElementByxpath("(//td[@class='login_title'])[2]"));
		Assert.assertEquals("verify Book hotel","Book A Hotel", text4);
		System.out.println(text4);
		
		type( findElementById("first_name"),  getData("Data", 1, 8));
		
		type(findElementById("last_name"),  getData("Data", 1, 9));
		
		type(findElementById("address"), getData("Data", 1, 10));
		
		type(findElementByName("cc_num"), getData("Data", 1, 11));
		
		selectOptionsByText( findElementById("cc_type"), getData("Data", 1, 12));
		
		selectOptionsByText(findElementById("cc_exp_month"), getData("Data", 1, 13));
		
		selectOptionByAttribute(findElementById("cc_exp_year"), getData("Data", 1, 14));
		
		type(findElementById("cc_cvv"), getData("Data", 1, 15));
		
		click( findElementById("book_now"));

		String text = getAttributeValue(findElementById("order_no"));

		outData("D:\\Pradeep\\ECLIPS\\eclipse\\MavenFirstProject\\ExcellSam\\Adactinhotel.xlsx", "Data", 1, 16, text);
		
		String text5 = getText(findElementByxpath("//td[@class='login_title']"));
		Assert.assertEquals("verify booking confirmation", "Booking Confirmation", text5);
		System.out.println(text5);
		
		click(findElementByxpath("//a[text()='Booked Itinerary']"));
		
		type(findElementByxpath("//input[@name='order_id_text']"), getData("Data", 1, 16));
		
		click( findElementByxpath("//input[@id='search_hotel_id']"));
		
		click(findElementByxpath("//input[@name='ids[]']"));
		
		click(findElementByxpath("(//input[contains(@value,'Cancel')])[1]"));
		
		alertAccept();
		
		
		String text6 = getText(findElementByxpath("//label[contains(@id,'search_result_error')]"));
		Assert.assertEquals("verify cancel confirmation","The booking has been cancelled.", text6);
		System.out.println(text6);
		
		
		
		
		
	}
		
		
	}
	
	
