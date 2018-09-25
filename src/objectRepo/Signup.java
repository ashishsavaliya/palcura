package objectRepo;

import org.openqa.selenium.By;

public class Signup {
	
	public By btn_signup = By.className("signUp");
	public By ddl_role = By.id("adduserform-user_type");
	public By txt_firstName = By.id("adduserform-firstname");
	public By txt_lastName = By.id("adduserform-lastname");
	public By txt_Email = By.id("adduserform-email");
	public By txt_password = By.id("adduserform-password");
	public By txt_zipCode = By.id("adduserform-zip_code");
	public By rd_age = By.className("user_dob");
	public By chb_terms = By.id("adduserform-accept_terms");
	public By btn_submit = By.id("AddUser-submit");
	
	public By msg_success = By.xpath("//h2[@class='text-center contactTilte thank-title']");
	
}
