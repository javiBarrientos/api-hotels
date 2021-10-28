package com.tourism.comparahoteles.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.comparahoteles.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	Optional<Hotel> findByName(Hotel name);
}
