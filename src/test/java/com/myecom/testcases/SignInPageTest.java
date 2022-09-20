package com.myecom.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.myecom.base.BaseClass;
import com.myecom.pom.IndexPagePom;
import com.myecom.pom.SignInPagePom;
import com.myecom.utiltiy.ExcelSheetHandle;

public class SignInPageTest extends BaseClass 
{
	ExcelSheetHandle data = new ExcelSheetHandle();
	IndexPagePom indexPagePom;
	SignInPagePom signInPagePom;
	SoftAssert SoftAssert= new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		loadAppication();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void createac() {
		indexPagePom = new IndexPagePom();
		signInPagePom = indexPagePom.ClickOnSigninButton();
		String createloginurl = signInPagePom.createlogin();
		SoftAssert.assertEquals(createloginurl, "http://automationpractice.com/index.php?controller=authentication#account-creation");
		
	}
	
	
	@Test
	public void login() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException {
		//data.getSheet(fis, "LogIn");
		Sheet sh = data.getSheet(data.getExcelFile(), "SignIn");
		Map<String,Object>logindata = data.getExcelSheetData(sh);
		indexPagePom = new IndexPagePom();
		signInPagePom = indexPagePom.ClickOnSigninButton();
		String SignInclickurl=signInPagePom.setLoginText((String)logindata.get("username"),(String)logindata.get("password"));
		Thread.sleep(3000);
		SoftAssert.assertEquals(SignInclickurl, "http://automationpractice.com/index.php?controller=authentication");
	}
}
