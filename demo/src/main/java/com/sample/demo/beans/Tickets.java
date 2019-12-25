package com.sample.demo.beans;

import java.sql.Timestamp;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("tickets")
public class Tickets {

	@PrimaryKeyColumn(name = "ticket_id", ordinal = 2, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.ASCENDING)
	private final int ticketId;

	@Column("destination")
	private final String destination;

	@Column("source")
	private final String source;

	@Column("jouney_date")
	private final Timestamp jouneyDate;

	@Column("rid")
	private final int regId;

	@Column("seat_no")
	private final int seatNo;

	@Column("train_no")
	private final int trainNo;

	@Column("uname")
	private final String userName;

	@Column("train_name")
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
