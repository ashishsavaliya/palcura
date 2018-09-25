package testCase;



import org.testng.annotations.Test; 

import utilities.BaseClass;

public class TC01_Register extends BaseClass {

	@Test(priority = 1, enabled = true)
	public void ownerSignup() {

		objSeleutils.click(objSignup.btn_signup);
		objSeleutils.selectByIndex(objSignup.ddl_role, 0);
		objSeleutils.enterText(objSignup.txt_firstName, objExcel.ReadExcel("Signup", 0, 0));
		objSeleutils.enterText(objSignup.txt_lastName, objExcel.ReadExcel("Signup", 1, 0));
		objSeleutils.enterText(objSignup.txt_Email, objExcel.ReadExcel("Signup", 2, 0));
		objSeleutils.enterText(objSignup.txt_password, objExcel.ReadExcel("Signup", 3, 0));
		objSeleutils.enterText(objSignup.txt_zipCode, objExcel.ReadExcel("Signup", 4, 0));
		objSeleutils.click(objSignup.rd_age);
		objSeleutils.click(objSignup.chb_terms);
		objSeleutils.click(objSignup.btn_submit);
		objSeleutils.implicitWait();

		objLoginSuccess.successVerify();

	}

	@Test(priority = 2, enabled = false)
	public void sitterSignup() {
		objSeleutils.click(objSignup.btn_signup);
		objSeleutils.selectByIndex(objSignup.ddl_role, 1);
		objSeleutils.enterText(objSignup.txt_firstName, objExcel.ReadExcel("Signup", 0, 1));
		objSeleutils.enterText(objSignup.txt_lastName, objExcel.ReadExcel("Signup", 1, 1));
		objSeleutils.enterText(objSignup.txt_Email, objExcel.ReadExcel("Signup", 2, 1));
		objSeleutils.enterText(objSignup.txt_password, objExcel.ReadExcel("Signup", 3, 1));
		objSeleutils.enterText(objSignup.txt_zipCode, objExcel.ReadExcel("Signup", 4, 1));
		objSeleutils.click(objSignup.rd_age);
		objSeleutils.click(objSignup.chb_terms);
		objSeleutils.click(objSignup.btn_submit);
		objSeleutils.implicitWait();

		objLoginSuccess.successVerify();

	}

	@Test(priority = 3, enabled = false)
	public void borrowerSignup() {
		objSeleutils.click(objSignup.btn_signup);
		objSeleutils.selectByIndex(objSignup.ddl_role, 2);
		objSeleutils.enterText(objSignup.txt_firstName, objExcel.ReadExcel("Signup", 0, 2));
		objSeleutils.enterText(objSignup.txt_lastName, objExcel.ReadExcel("Signup", 1, 2));
		objSeleutils.enterText(objSignup.txt_Email, objExcel.ReadExcel("Signup", 2, 2));
		objSeleutils.enterText(objSignup.txt_password, objExcel.ReadExcel("Signup", 3, 2));
		objSeleutils.enterText(objSignup.txt_zipCode, objExcel.ReadExcel("Signup", 4, 2));
		objSeleutils.click(objSignup.rd_age);
		objSeleutils.click(objSignup.chb_terms);
		objSeleutils.click(objSignup.btn_submit);
		objSeleutils.implicitWait();

		objLoginSuccess.successVerify();

	}
}
