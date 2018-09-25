package common;

import utilities.BaseClass;

public class LoginSuccess extends BaseClass{

public void successVerify() {
		
		String success = objSeleutils.getText(objSignup.msg_success);
		String message = "thank you for registering!";

		String failMessage = "Success Message not found. Sign up Failed..!";
		objSeleutils.assertVerify(success, message, failMessage);		
	}
}
