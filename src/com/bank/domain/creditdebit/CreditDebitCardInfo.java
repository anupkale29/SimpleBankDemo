package com.bank.domain.creditdebit;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.bank.domain.account.Account;
import com.bank.domain.fingerprint.FingerPrint;
@Entity
@Table(name="creditdebitcardinfo")
public class CreditDebitCardInfo {
	private int creditDebitId;
	private int cardType;
	private String cardHolderName;
	private long creditDebitCardNumber;
	private String expiryDate;
	private int cvv;
	private int pin;
	private Account cardAccount;
	private String regMin1; 
	private String regMin2;
	private String regMin3;
	
	
	@Id
	@GeneratedValue
	@Column(name="creditdebitid")
	public int getCreditDebitId() {
		return creditDebitId;
	}
	public void setCreditDebitId(int creditDebitId) {
		this.creditDebitId = creditDebitId;
	}
	@Column(name="cardtype")
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	@Column(name="cardholdername")
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	@Column(name="creditdebitcardnumber")
	public long getCreditDebitCardNumber() {
		return creditDebitCardNumber;
	}
	public void setCreditDebitCardNumber(long creditDebitCardNumber) {
		this.creditDebitCardNumber = creditDebitCardNumber;
	}
	@Column(name="expirydate")
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cardaccount", referencedColumnName="accountid")
	public Account getCardAccount() {
		return cardAccount;
	}
	public void setCardAccount(Account cardAccount) {
		this.cardAccount = cardAccount;
	}
	@Column(name="cvv")
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Column(name="pin")
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Column(name="regmin1", columnDefinition="TEXT")
	public String getRegMin1() {
		return regMin1;
	}
	public void setRegMin1(String regMin1) {
		this.regMin1 = regMin1;
	}
	@Column(name="regmin2", columnDefinition="TEXT")
	public String getRegMin2() {
		return regMin2;
	}
	public void setRegMin2(String regMin2) {
		this.regMin2 = regMin2;
	}
	@Column(name="regmin3", columnDefinition="TEXT")
	public String getRegMin3() {
		return regMin3;
	}
	public void setRegMin3(String regMin3) {
		this.regMin3 = regMin3;
	}
	
}
