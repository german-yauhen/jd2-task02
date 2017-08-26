package by.htp.hermanovich.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import by.htp.hermanovich.constant.Constants;

/**
 * This class describes a summary object of registration.
 * @author Hermanovich Yauheni
 */
public class User {

	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	private String name;

	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	private String surname;

	private String document;
	private String sex;
	private String dateOfBirth;

	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	private String login;
	
	@NotNull(message = "The password field must not be empty")
	@Pattern(regexp = "^[a-zA-Z0-9]{4,8}", message = "Must contains 4-8 chars/digits")
	private String password;
	
	private String country;
	private List<String> genderTypes;
	
	public User() {
		genderTypes = new ArrayList<>();
		genderTypes.add(Constants.MALE);
		genderTypes.add(Constants.FEMALE);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getGenderTypes() {
		return genderTypes;
	}

	public void setGenderTypes(List<String> genderTypes) {
		this.genderTypes = genderTypes;
	}

}