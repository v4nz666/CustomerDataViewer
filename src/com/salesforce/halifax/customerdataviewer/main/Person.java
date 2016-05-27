package com.salesforce.halifax.customerdataviewer.main;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

	// TODO: add .xsd

	private String lastName;
	private String firstName;
	private Integer age;
	private Double balance;
	private Integer id;

	public Integer getAge() {
		return age;
	}
	public Double getBalance() {
		return balance;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@XmlElement
	public void setAge(String attribute) {
		Integer age = Integer.parseInt(attribute);
		setAge(age);
	}

	@XmlElement
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public void setBalance(String string) {
		String cleanedString = string.replaceAll(",", "");
		Double balance = Double.parseDouble(cleanedString);
		setBalance(balance);
	}

	@XmlElement
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@XmlElement
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public void setId(String attribute) {
		Integer id = Integer.parseInt(attribute);
		setId(id);
	}
}
