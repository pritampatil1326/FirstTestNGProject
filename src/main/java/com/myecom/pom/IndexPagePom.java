package com.myecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecom.base.BaseClass;

public class IndexPagePom extends BaseClass
	{
		public IndexPagePom()
		{
			PageFactory.initElements(driver, this);
			
		}
		
		@FindBy(xpath= "//img[@class='logo img-responsive']")
		WebElement logo;
		
		@FindBy(xpath= "//a[@title='Log in to your customer account']")
		WebElement signin;
		
		@FindBy(id="search_query_top")
		WebElement searchProductbox;
		
		@FindBy(name="submit_search")
		WebElement searchButton;
		
		public boolean validateLogo() {
			if(logo.isDisplayed()) {
				System.out.println("logo is available");
				return true;
			}
			else {
				return false;
			}
		}
		public String gettitleofpage() {
			String gettitle = driver.getTitle();
			return gettitle;
			
		}
		public SignInPagePom ClickOnSigninButton() {
			signin.click();
			return new SignInPagePom();
		}
		public void SetSearchText() {
			searchProductbox.sendKeys("T-Shirt");
		}
		public ProductListingPom ClickOnSearch() {
			searchButton.click();
			return new ProductListingPom();
		}
		
		
		

}
