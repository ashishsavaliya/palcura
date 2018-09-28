package objectRepo;

import org.openqa.selenium.By;

public class Login {
	
	public By lbl_signin = By.xpath("//a[@title='Sign In']");
	public By txt_email = By.id("loginform-email");
	public By txt_password = By.id("loginform-password");
	public By btn_signup = By.name("login-button");
	public By btn_findPet = By.xpath("(//button[@class='orangebtn'])[1]");
	
	public By ddl_welcome = By.xpath("//div[@class='dropdown']");
	
}
