package com.sample.demo.beans;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Registration {

	@PrimaryKeyColumn
	private final String userName;

	@PrimaryKeyColumn
	private final int registrationId;

	@Column
	private final String mobileNo;

	@Column
	private final String password;

	public Registration(String userName, int registrationId, String mobileNo, String password) {
		this.userName = userName;
		this.registrationId = registrationId;
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Registration [userName=" + userName + ", registrationId=" + registrationId + ", mobileNo=" + mobileNo
				+ ", password=" + password + "]";
	}

}
