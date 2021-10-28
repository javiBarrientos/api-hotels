package com.tourism.comparahoteles.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "hotels", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 30)
	private String name;

	@NotBlank
	@Size(max = 30)
	private String location;

	@NotBlank
	@Size(max = 30)
	private String zone;

	@NotBlank
	@Column(precision = 19, scale = 15)
	private BigDecimal latitude;

	@NotBlank
	@Column(precision = 19, scale = 15)
	private BigDecimal altitude;

	@NotBlank
	private double stars;

	@NotBlank
	private int valorations;

	@NotBlank
	private int comments;

	@NotBlank
	private int maxPeople;

	@NotBlank
	private boolean wifi;

	@NotBlank
	private boolean breakfast;

	public Hotel() {

	}

	public Hotel(String name, String location, String zone, BigDecimal latitude, BigDecimal altitude, double stars,
			int valorations, int comments, int maxPeople, boolean wifi, boolean breakfast) {
		this.name = name;
		this.location = location;
		this.zone = zone;
		this.latitude = latitude;
		this.altitude = altitude;
		this.stars = stars;
		this.valorations = valorations;
		this.comments = comments;
		this.maxPeople = maxPeople;
		this.wifi = wifi;
		this.breakfast = breakfast;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getAltitude() {
		return altitude;
	}

	public void setAltitude(BigDecimal altitude) {
		this.altitude = altitude;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public int getValorations() {
		return valorations;
	}

	public void setValorations(int valorations) {
		this.valorations = valorations;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

}
