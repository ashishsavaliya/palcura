package objectRepo;

import org.openqa.selenium.By;

public class Profile {

	public By ddl_welcome = By.xpath("//div[@class='dropdown']");
	public By lbl_profile = By.xpath("//a[contains(text(),'Your Profile')]");
	public By lbl_headerTitle = By.xpath("//h1[contains(text(),'Your Profile')]");
	
	public By btn_editProfile = By.xpath("//a[@class='orangeBtn']");
	
	public By txt_firstName = By.id("updatesitter-firstname");
	public By txt_lasttName = By.id("updatesitter-lastname");
	public By txt_address = By.id("search_destination1");
	public By txt_zipCode = By.id("updatesitter-zip_code");
	public By ddl_country = By.id("updatesitter-country");
	
	public By ddl_state = By.xpath("(//button[@class='btn dropdown-toggle btn-default'])[1]");
	public By select_state = By.xpath("(//ul[@class='dropdown-menu inner'])[1]/li[3]");
	
	public By ddl_city = By.xpath("(//button[@class='btn dropdown-toggle btn-default'])[2]");
	public By select_city = By.xpath("(//ul[@class='dropdown-menu inner'])[2]/li[3]");
	
	public By btn_uploadProfileImage = By.id("userprofilepictureupload-profile_image");
	public By txt_pitch = By.id("updatesitter-pitch");
	public By btn_uploadSecurityImage = By.id("uploads-upload_documents");
	public By btn_uploadHomeImage = By.id("uploads-upload_home_images");
	public By btn_petCare = By.xpath("(//div[@class='checkbox'])[1]");
	public By ddl_petSize = By.className("btn dropdown-toggle btn-default");
	
	public By btn_save = By.id("editUser-submit");
	
	public By msg_success = By.xpath("(//div[@class='col-xs-12'])[3]");
	
}
