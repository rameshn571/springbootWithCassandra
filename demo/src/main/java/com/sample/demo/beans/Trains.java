package com.sample.demo.beans;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Trains {

	@PrimaryKeyColumn
	private final int trainId;

	@PrimaryKeyColumn
	private final String trainName;

	@PrimaryKeyColumn
	private final int trainNo;

	@Column
	private final int currentSeats;

	@Column
	private final String source;

	@Column
	private final String destination;

	@Column
	private final int totalSeats;

	public Trains(int trainId, String trainName, int trainNo, int currentSeats, String source, String destination,
			int totalSeats) {
		super();
		this.trainId = trainId;
		this.trainName = trainName;
		this.trainNo = trainNo;
		this.currentSeats = currentSeats;
		this.source = source;
		this.destination = destination;
		this.totalSeats = totalSeats;
	}

	public int getTrainId() {
		return trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public int getCurrentSeats() {
		return currentSeats;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	@Override
	public String toString() {
		return "Trains [trainId=" + trainId + ", trainName=" + trainName + ", trainNo=" + trainNo + ", currentSeats="
				+ currentSeats + ", source=" + source + ", destination=" + destination + ", totalSeats=" + totalSeats
				+ "]";
	}

}