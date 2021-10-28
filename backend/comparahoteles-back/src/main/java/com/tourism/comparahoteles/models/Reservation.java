package com.tourism.comparahoteles.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "reservations", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Temporal(TemporalType.DATE)
	private Date date_in;

	@NotBlank
	@Temporal(TemporalType.DATE)
	private Date date_out;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	public Reservation() {

	}

	public Reservation(int id, Date date_in, Date date_out, User user) {
		this.id = id;
		this.date_in = date_in;
		this.date_out = date_out;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_in() {
		return date_in;
	}

	public void setDate_in(Date date_in) {
		this.date_in = date_in;
	}

	public Date getDate_out() {
		return date_out;
	}

	public void setDate_out(Date date_out) {
		this.date_out = date_out;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
