package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class AccountData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String accountNumber;
	
	private String accountType;
	
	private String ifscCode;
	
	private String accountHolderName;
	
	private String bankbranch;
	
	private double totalBalance;
	
	private String accountOpeningDate;
	
	@Type(type="yes_no")
	private boolean status;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "a_t_id")
	private List<TransactionData> txtList = new  ArrayList<TransactionData>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getBankbranch() {
		return bankbranch;
	}

	public void setBankbranch(String bankbranch) {
		this.bankbranch = bankbranch;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public String getAccountOpeningDate() {
		return accountOpeningDate;
	}

	public void setAccountOpeningDate(String accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	public List<TransactionData> getTxtList() {
		return txtList;
	}

	public void setTxtList(List<TransactionData> txtList) {
		this.txtList = txtList;
	}

	@Override
	public String toString() {
		return "AccountData [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", ifscCode=" + ifscCode + ", accountHolderName=" + accountHolderName + ", bankbranch=" + bankbranch
				+ ", totalBalance=" + totalBalance + ", accountOpeningDate=" + accountOpeningDate + ", status=" + status
				+ "]";
	}
	


}
