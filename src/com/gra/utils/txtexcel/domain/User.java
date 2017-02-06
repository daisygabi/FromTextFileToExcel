package com.gra.utils.txtexcel.domain;

/**
 * Registration user POJO class
 * 
 * @author gabrielaradu
 *
 */
public class User {

	private String firstname;
	private String surname;
	private String hometown;
	private String telephone;
	private String email;
	private String course;
	private String url;
	private String source;
	private String promotion;
	private String optin;

	public User(String firstname, String surname, String hometown, String telephone, String email, String course,
			String url, String source, String promotion, String optin) {
		this.firstname = firstname;
		this.surname = surname;
		this.hometown = hometown;
		this.telephone = telephone;
		this.email = email;
		this.course = course;
		this.url = url;
		this.source = source;
		this.promotion = promotion;
		this.optin = optin;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getOptin() {
		return optin;
	}

	public void setOptin(String optin) {
		this.optin = optin;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(firstname);
		buffer.append("," + surname);
		buffer.append("," + hometown);
		buffer.append("," + telephone);
		buffer.append("," + email);
		buffer.append("," + course);
		buffer.append("," + url);
		buffer.append("," + source);
		buffer.append("," + promotion);
		buffer.append("," + optin);
		buffer.append("\n---------------------");
		return buffer.toString();
	}
}