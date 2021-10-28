package com.tourism.comparahoteles.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "rooms", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	private String room_type;

	@NotBlank
	private double fee;

	@NotBlank
	private int max_people;

	@NotBlank
	private int min_people;

	@ManyToOne
	@JoinColumn(name = "hotel_id", referencedColumnName = "id")
	private Hotel hotel;

	public Room() {

	}

	public Room(long id, String room_type, double fee, int max_people, int min_people, Hotel hotel) {
		this.id = id;
		this.room_type = room_type;
		this.fee = fee;
		this.max_people = max_people;
		this.min_people = min_people;
		this.hotel = hotel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getMax_people() {
		return max_people;
	}

	public void setMax_people(int max_people) {
		this.max_people = max_people;
	}

	public int getMin_people() {
		return min_people;
	}

	public void setMin_people(int min_people) {
		this.min_people = min_people;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
