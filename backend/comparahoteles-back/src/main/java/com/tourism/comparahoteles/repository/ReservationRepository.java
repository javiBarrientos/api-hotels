package com.tourism.comparahoteles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.comparahoteles.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
