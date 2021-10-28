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
@Table(name = "rooms_reservations", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class RoomReservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room_id;
	
	@ManyToOne
	@JoinColumn(name = "reservation_id")
	private Reservation reservation_id;
	
	@NotBlank
	private boolean is_reserved;
	
}
