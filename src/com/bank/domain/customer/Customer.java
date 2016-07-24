package com.bank.domain.customer;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.bank.domain.account.Account;
@Entity
@Table(name="customer")
public class Customer {
	
	private int customerId;
	private String firstName;
	private String lastName;;
	private String emailID;
	private String password;
	private long phoneNumber;
	private String address;
	private String city;
	private String pincode;
	private String country;
	private Map<Integer,Account> accounts=new HashMap<Integer, Account>();
	    
    @Id
	@GeneratedValue
	@Column(name="customerid")
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Column(name="firstname")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="lastname")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="emailid")
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	@Column(name="phonenumber")	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="pincode")
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Column(name="country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="password ")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="accounts")
	@ManyToMany(mappedBy="customers", fetch = FetchType.EAGER)
	@MapKey(name="accountId")
	@JsonBackReference
	public Map<Integer, Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Map<Integer, Account> accounts) {
		this.accounts = accounts;
	}
}
