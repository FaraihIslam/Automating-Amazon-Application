package com.amazonproject.testcases;


import org.testng.annotations.Test;

import com.amazonproject.pageobject.AmazonProduct;

public class AmazonTypesOfProduct extends BaseClass {

	@Test
	public void amazonWebPage() throws InterruptedException {

		AmazonProduct ap = new AmazonProduct(driver);
		ap.enterMobileNameInSearchBox("Samsung Mobile");
		ap.clickSearchButton();
	//	ap.checkBox();
		ap.listOfAllMobileTypes();
		ap.databaseConnection();
		
	}

}
