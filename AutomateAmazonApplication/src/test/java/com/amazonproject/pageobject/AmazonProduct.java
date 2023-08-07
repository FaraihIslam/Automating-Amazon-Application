package com.amazonproject.pageobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AmazonProduct {

	WebDriver ldriver;
	List<String> mobileList=new ArrayList<String>();

	public AmazonProduct(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	WebElement enterSearchButton;

	@FindBy(xpath = "(//i[@class='a-icon a-icon-checkbox'])[3]")
	WebElement checkNokiaCheckbox;

	@FindBys(@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']"))
	private List<WebElement> listOfMobileTypes;

	
/*	 @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	 WebElement listOfMobileTypes;*/
	 

	@FindBy(xpath = "//a[@class='s-pagination-item s-pagination-button']")
	WebElement rowNo;


	public void enterMobileNameInSearchBox(String mobile) {
		searchBox.sendKeys(mobile);
	}

	public void clickSearchButton() {
		enterSearchButton.click();

	}

	public void checkBox() {
		checkNokiaCheckbox.click();
	}
	
	public void listOfAllMobileTypes() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("window.scrollBy(0,1000)");
		System.out.println("Faraih Islam");
		System.out.println(listOfMobileTypes.size());
		for(WebElement mobileName:listOfMobileTypes) {
		System.out.println(mobileName.getText());
		mobileList.add(mobileName.getText());
		}
		System.out.println("---------------");
		System.out.println(mobileList);
	/*	List<WebElement> mobileTypes=ldriver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println(mobileTypes.size());*/
	}
		
		public void databaseConnection() {
			
		String host= "localhost";
		String port="3306";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://"+ host + " : " + port + "/testing","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("");
			while(rs.next()) {
				System.out.println(rs.getString("MobileTypes"));
			}
		}catch(Exception e) {
		     e.printStackTrace();
		}
	}
}
