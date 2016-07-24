package com.bank.domain.account;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.bank.domain.creditdebit.CreditDebitCardInfo;
import com.bank.domain.customer.Customer;
@Entity
@Table(name="account")
public class Account {
	private int accountId;
	private String accountType;
	private long accountNumber;
	private double accountBalance;
	private CreditDebitCardInfo creditDebitCardInfo;
	private Map<Integer,Customer> customers=new HashMap<Integer, Customer>();
	@Id
	@GeneratedValue
	@Column(name="accountid")
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	@Column(name="accountype")
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Column(name="accountnumber")
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Column(name="accountbalance")
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
//	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="accounts_customers", 
                joinColumns={@JoinColumn(name="account",referencedColumnName="accountid")}, 
                inverseJoinColumns={@JoinColumn(name="customer",referencedColumnName="customerid")})
	@MapKey(name="customerId")
	public Map<Integer, Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Map<Integer, Customer> customers) {
		this.customers = customers;
	}
	@OneToOne(mappedBy="cardAccount", cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonBackReference
	public CreditDebitCardInfo getCreditDebitCardInfo() {
		return creditDebitCardInfo;
	}
	public void setCreditDebitCardInfo(CreditDebitCardInfo creditDebitCardInfo) {
		this.creditDebitCardInfo = creditDebitCardInfo;
	}
	
	
	
}
