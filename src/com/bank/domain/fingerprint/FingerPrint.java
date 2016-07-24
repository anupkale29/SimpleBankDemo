package com.bank.domain.fingerprint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bank.domain.creditdebit.CreditDebitCardInfo;

@Entity
@Table(name="fingerprint")
public class FingerPrint {
	
	int fingerPrintId;
	private CreditDebitCardInfo creditDebitCardInfo;
	private String regMin;
	String ipAddress;
	long timestamp;
	boolean successFailure;
	boolean verified=false;
	String date;
	String time;
	
	
	@Id
	@GeneratedValue
	@Column(name="fingerprintid")
	public int getFingerPrintId() {
		return fingerPrintId;
	}
	public void setFingerPrintId(int fingerPrintId) {
		this.fingerPrintId = fingerPrintId;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="creditdebitcardinfo", referencedColumnName="creditdebitid")
	public CreditDebitCardInfo getCreditDebitCardInfo() {
		return creditDebitCardInfo;
	}
	
	public void setCreditDebitCardInfo(CreditDebitCardInfo creditDebitCardInfo) {
		this.creditDebitCardInfo = creditDebitCardInfo;
	}
	
	@Column(name="regmin" , columnDefinition="TEXT")
	public String getRegMin() {
		return regMin;
	}
	
	public void setRegMin(String regMin) {
		this.regMin = regMin;
	}
	@Column(name="ipaddress")
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	@Column(name="timestamp")
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	@Column(name="successfailure")
	public boolean isSuccessFailure() {
		return successFailure;
	}
	public void setSuccessFailure(boolean successFailure) {
		this.successFailure = successFailure;
	}
	@Column(name="verified")
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	@Column(name="date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Column(name="time")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
