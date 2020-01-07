package com.sample.demo.beans;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table("registration")
public class Registration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4258656733454066327L;

	@PrimaryKeyColumn(name = "uname", ordinal = 2, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.ASCENDING)
	@JsonProperty("userName")
	private final String userName;

	@PrimaryKeyColumn(name = "id", ordinal = 1, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.ASCENDING)
	@JsonProperty("registrationId")
	private final int registrationId;

	@Column("mobile_no")
	@JsonProperty("mobileNo")
	private final String mobileNo;

	@Column("password")
	@JsonProperty("password")
	private final String password;

	public Registration(@JsonProperty("userName") String userName, @JsonProperty("registrationId") int registrationId,
			@JsonProperty("mobileNo") String mobileNo, @JsonProperty("password") String password) {
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
