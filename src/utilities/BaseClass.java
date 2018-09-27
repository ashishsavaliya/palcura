package utilities;

import common.LoginSuccess;
import objectRepo.Login;
import objectRepo.Profile;
import objectRepo.Signup;

public class BaseClass extends SeleniumUtilis{
	
	public static SeleniumUtilis objSeleutils = new SeleniumUtilis();
	public static Signup objSignup = new Signup();
	public static Login objLogin = new Login();
	public static Profile objProfile = new Profile();
	
	
	public static ExcelUtils objExcel = new ExcelUtils();
	
	public static LoginSuccess objLoginSuccess = new LoginSuccess();
	

}
