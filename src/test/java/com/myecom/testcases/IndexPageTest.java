package com.myecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.myecom.base.BaseClass;
import com.myecom.pom.IndexPagePom;
import com.myecom.pom.ProductListingPom;


public class IndexPageTest extends BaseClass {
	
		
		IndexPagePom indexPagePom;
		ProductListingPom productListingPom;
		SoftAssert SoftAssert= new SoftAssert();   //SoftAssert EX
		
		
		@BeforeMethod
		public void setUp() {
			loadAppication();
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		@Test
		public void validateLogo() {
			indexPagePom = new IndexPagePom();
			boolean res = indexPagePom.validateLogo();
			Assert.assertTrue(res);
		}
		@Test
		public void test() {
			System.out.println("Open  Webpage");
			//Assert.assertEquals(false, true);  HardAssert
			System.out.println("Check Logo");
			SoftAssert.assertAll();
			System.out.println("Title Check");
			System.out.println("Click on sign in");
		}
		@Test
		public void validatetitle() {
			String title = indexPagePom.gettitleofpage();
			Assert.assertEquals(title, "My Store"); //HardAssert
		}
		@Test
		public void ClickOnSignIn() {
			indexPagePom = new IndexPagePom();
			indexPagePom.ClickOnSigninButton();
		}
		@Test
		public void validateSearchBoxText() {
			indexPagePom = new IndexPagePom();
			indexPagePom.SetSearchText();
		}
		@Test
		public void validateSearchBoxClick() {
			indexPagePom = new IndexPagePom();
			indexPagePom.ClickOnSearch();
		}
		@Test
		public void validatetshirtclick() {
			productListingPom= new ProductListingPom();
			productListingPom.clickShirt();
			String searchPageHeading = productListingPom.getSearchPageHeading();
			Assert.assertEquals(searchPageHeading,"T-shirts - My Store");
		}
		
		

}



