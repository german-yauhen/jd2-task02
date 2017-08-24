package by.htp.hermanovich.domain;

import java.util.ArrayList;
import java.util.List;

import by.htp.hermanovich.constants.Constants;

/**
 * This class describes a summary object of registration.
 * @author Hermanovich Yauheni
 */
public class RegistrationData {
	private String name;
	private String surname;
	private String document;
	private String sex;
	private String dateOfBirth;
	private String login;
	private String password;
	private String country;
	private List<String> genderTypes;
	
	public RegistrationData() {
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