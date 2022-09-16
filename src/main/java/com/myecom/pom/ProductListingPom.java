package com.myecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecom.base.BaseClass;

public class ProductListingPom extends BaseClass
{
	public ProductListingPom() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[3]/a[1]")
	WebElement tshirt;
	
	public String getSearchPageHeading() {
		String heading= driver.getTitle();
				return heading;
	}

	public void clickShirt() {
		// TODO Auto-generated method stub
		tshirt.click();
	}
	

}
