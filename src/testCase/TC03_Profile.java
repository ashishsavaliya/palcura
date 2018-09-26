package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class TC03_Profile extends BaseClass {

	@Test
	public void editProfile() throws IOException {

		objSeleutils.click(objProfile.ddl_welcome);
		objSeleutils.click(objProfile.lbl_profile);

		// boolean lbl_header = objSeleutils.existsElement(objProfile.lbl_headerTitle);
		// objSeleutils.assertElementVerify(lbl_header, true, "Page Title Not
		// Found..!");

		objSeleutils.click(objProfile.btn_editProfile);

		objSeleutils.enterText(objProfile.txt_firstName, objExcel.ReadExcel("SignUp", 5, 0));
		objSeleutils.enterText(objProfile.txt_lasttName, objExcel.ReadExcel("SignUp", 6, 0));
		objSeleutils.enterText(objProfile.txt_address, objExcel.ReadExcel("SignUp", 7, 0));
		objSeleutils.enterText(objProfile.txt_zipCode, objExcel.ReadExcel("SignUp", 8, 0));
		objSeleutils.click(objProfile.ddl_state);
		objSeleutils.click(objProfile.select_state);

		objSeleutils.click(objProfile.ddl_city);
		objSeleutils.click(objProfile.select_city);

		objSeleutils.fileUpload(objProfile.btn_uploadProfileImage, "./images/2.jpg");
		objSeleutils.enterText(objProfile.txt_pitch, "We are taking only two pets at a time.");
		objSeleutils.fileUpload(objProfile.btn_uploadSecurityImage, "./images/5.jpg");
		objSeleutils.click(objProfile.btn_save);

		if (objSeleutils.existsElement(objProfile.msg_success)) {
			String successMessage = objSeleutils.getText(objProfile.msg_success);
			System.out.println(successMessage);
			objSeleutils.tackScreenShot("./img/ProfilSuccess.jpg");
		} else {

			objSeleutils.tackScreenShot("./img/ProfileError.jpg");
			System.out.println("Success Message Not Found..!");
		}

	}
}
