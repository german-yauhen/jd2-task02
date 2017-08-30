package by.htp.hermanovich.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Login {
	
	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	private String login;
	
	@NotNull(message = "The password field must not be empty")
	@Pattern(regexp = "^[a-zA-Z0-9]{4,8}", message = "Must contains 4-8 chars/digits")
	private String password;
	
	public Login() {
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}