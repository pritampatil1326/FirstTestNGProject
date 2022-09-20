package com.myecom.pom;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecom.base.BaseClass;

public class SignInPagePom extends BaseClass {
	public SignInPagePom() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	@FindBy(xpath="//input[@id='passwd']")
	WebElement pass;
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")
	WebElement signclick;
	@FindBy(xpath="//input[@id=\"email_create\"]")
	WebElement forloginemail;;
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/button[1]/span[1]")
	WebElement loginbutton;
	
	public String createlogin() {
		forloginemail.sendKeys("pritampatil1326@gmail.com");
		loginbutton.click();
		String createloginurl= driver.getCurrentUrl();
		return createloginurl;
	}
	public String setLoginText(String username, String password) {
		email.sendKeys(username);
		pass.sendKeys(password);
		signclick.click();
		String signclickurl = driver.getCurrentUrl();
		return signclickurl;
	}

	
}
