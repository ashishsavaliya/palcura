package testCase;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class TC03_Profile extends BaseClass {

	@Test
	public void editProfile() {

		objSeleutils.click(objProfile.ddl_welcome);
		objSeleutils.click(objProfile.lbl_profile);
		
		//boolean lbl_header = objSeleutils.existsElement(objProfile.lbl_headerTitle);
		//objSeleutils.assertElementVerify(lbl_header, true, "Page Title Not Found..!");
		
		objSeleutils.click(objProfile.btn_editProfile);
		
		objSeleutils.enterText(objProfile.txt_firstName, objExcel.ReadExcel("SignUp", 5, 0));
		objSeleutils.enterText(objProfile.txt_lasttName, objExcel.ReadExcel("SignUp", 6, 0));
		objSeleutils.enterText(objProfile.txt_address, objExcel.ReadExcel("SignUp", 7, 0));
		objSeleutils.enterText(objProfile.txt_zipCode, objExcel.ReadExcel("SignUp", 8, 0));
		objSeleutils.click(objProfile.ddl_state);
	}
}
