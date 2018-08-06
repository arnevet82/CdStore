package webapp.login;

public class LoginService {
	
	public boolean isUserValid(String user, String password) {
		if(user.equals("natalie") && password.equals("w2w2w2")) {
			return true;
		}
		return true;
	}

}
