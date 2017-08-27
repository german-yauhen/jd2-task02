package by.htp.hermanovich.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import by.htp.hermanovich.constant.Constants;

/**
 * This class describes a summary object of registration.
 * The entities of this class are used by Hibernate flamework.
 * The fields of the class annotated according to the corresponding columns
 * in the database table.
 * Constructor also initializes list of gender types automatically.
 * @author Hermanovich Yauheni
 */
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Integer id;

	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	@Column(name = "name")
	private String name;

	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	@Column(name = "surname")
	private String surname;

	@Column(name = "document")
	private String document;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	@Column(name = "login", unique = true)
	private String login;
	
	@NotNull(message = "The password field must not be empty")
	@Pattern(regexp = "^[a-zA-Z0-9]{4,8}", message = "Must contains 4-8 chars/digits")
	@Column(name = "password")
	private String password;
	
	@Column(name = "country")
	private String country;
	
	@Transient
	private List<String> genderTypes;
	
	@Transient
	private List<String> countries;
	
	public User() {
		genderTypes = new ArrayList<>();
		genderTypes.add(Constants.MALE);
		genderTypes.add(Constants.FEMALE);
		countries = new ArrayList<>();
		countries.add(Constants.BELARUS);
		countries.add(Constants.RUSSIA);
		countries.add(Constants.CZECH);
		countries.add(Constants.POLAND);
		countries.add(Constants.LITHUANIA);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<String> getCountries() {
		return countries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User " + name + " " + surname + ", document " + document + "; gender " + sex
				+ "; birth " + dateOfBirth + "; login " + login + ", password " + password + ", country "
				+ country;
	}

}