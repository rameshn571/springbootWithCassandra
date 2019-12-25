package com.sample.demo.beans;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("trains")
public class Trains {

	@PrimaryKeyColumn(name = "train_id", ordinal = 2, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.ASCENDING)
	private final int trainId;

	@PrimaryKeyColumn(name = "train_name", ordinal = 2, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.ASCENDING)
	private final String trainName;

	@PrimaryKeyColumn(name = "train_no", ordinal = 2, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.ASCENDING)
	private final int trainNo;

	@Column("current_seats")
	private final int currentSeats;

	@Column("source")
	private final String source;

	@Column("destination")
	private final String destination;

	@Column("total_seats")
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