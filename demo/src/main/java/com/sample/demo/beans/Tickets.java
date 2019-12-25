package com.sample.demo.beans;

import java.sql.Timestamp;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Tickets {

	@PrimaryKey
	private final int ticketId;

	@Column
	private final String destination;

	@Column
	private final String source;

	@Column
	private final Timestamp jouneyDate;

	@Column
	private final int regId;

	@Column
	private final int seatNo;

	@Column
	private final int trainNo;

	@Column
	private final String userName;

	@Column
	private final String trainName;

	public Tickets(int ticketId, String destination, String source, Timestamp jouneyDate, int regId, int seatNo,
			int trainNo, String userName, String trainName) {
		this.ticketId = ticketId;
		this.destination = destination;
		this.source = source;
		this.jouneyDate = jouneyDate;
		this.regId = regId;
		this.seatNo = seatNo;
		this.trainNo = trainNo;
		this.userName = userName;
		this.trainName = trainName;
	}

	public int getTicketId() {
		return ticketId;
	}

	public String getDestination() {
		return destination;
	}

	public String getSource() {
		return source;
	}

	public Timestamp getJouneyDate() {
		return jouneyDate;
	}

	public int getRegId() {
		return regId;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public String getUserName() {
		return userName;
	}

	public String getTrainName() {
		return trainName;
	}

	@Override
	public String toString() {
		return "Tickets [ticketId=" + ticketId + ", destination=" + destination + ", source=" + source + ", jouneyDate="
				+ jouneyDate + ", regId=" + regId + ", seatNo=" + seatNo + ", trainNo=" + trainNo + ", userName="
				+ userName + ", trainName=" + trainName + "]";
	}

}
