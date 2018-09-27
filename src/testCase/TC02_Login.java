package testCase;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class TC02_Login extends BaseClass {

	@Parameters({ "userName", "password" })
	@Test
	public void login(String userName, String password) throws InterruptedException, IOException {

		objSeleutils.click(objLogin.lbl_signin);
		objSeleutils.enterText(objLogin.txt_email, userName);
		objSeleutils.enterText(objLogin.txt_password, password);
		objSeleutils.click(objLogin.btn_signup);

		boolean txt_welcome = objSeleutils.existsElement(objLogin.ddl_welcome);

		if (txt_welcome == true) {
			System.out.println("Login Successfull.");
			objSeleutils.tackScreenShot("./Screenshots/LoginPass.png");
			
		}
		
		else {
			objSeleutils.tackScreenShot("./Screenshots/LoginFailed.png");
		}
	}
}
