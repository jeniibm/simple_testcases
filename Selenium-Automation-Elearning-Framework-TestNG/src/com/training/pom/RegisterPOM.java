package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
 
public class RegisterPOM {
	
private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='http://retail.upskills.in/account/account']")
	private WebElement account; 
	
	public void Register() throws InterruptedException
	{
	 this.account.click();
	 Thread.sleep(3000);
	 driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
	 Thread.sleep(3000);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(id="input-lastname")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-address-1")
	private WebElement address;
	
	@FindBy(id="input-city")
	private WebElement city;
	
	@FindBy(id="input-postcode")
	private WebElement postal;
	
	@FindBy(id="input-zone")
	private WebElement zone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirm_password;
	
	@FindBy(name="agree")
	private WebElement radiocheck;
	
	@FindBy(css="div.tb_text_wrap.tb_sep")
	private WebElement success;
	
	public void PersonalDetails(String firstname,String lastname, String email, String telephone)
	{
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
		this.email.sendKeys(email);
		this.telephone.sendKeys(telephone);
		
	}
	
	public void Address(String address, String city, String postal,int zone)
	{
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		this.postal.sendKeys(postal);
		Select se2 = new Select(this.zone);
		se2.selectByIndex(zone);
	}
	
	public void SetPassword(String password, String confirm)
	{
		this.password.sendKeys(password);
		this.confirm_password.sendKeys(confirm);
		
	}
	
	public void confirm() throws InterruptedException
	{
		this.radiocheck.click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		 Thread.sleep(3000);
		 String msg = "Congratulations! Your new account has been successfully created!";
		 String confirm_msg = this.success.getText();
		 Assert.assertEquals(msg, confirm_msg);
	}

}
