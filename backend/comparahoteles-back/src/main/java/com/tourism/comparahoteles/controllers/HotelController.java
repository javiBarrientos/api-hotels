package com.tourism.comparahoteles.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.comparahoteles.models.Hotel;
import com.tourism.comparahoteles.repository.HotelRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/hotels")
public class HotelController {

	@Autowired
	HotelRepository hotelRepository;

	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getAllHotels(@RequestParam(required = false) String name) {
		try {
			List<Hotel> hotels = new ArrayList<Hotel>();

			if (name == null)
				hotelRepository.findAll().forEach(hotels::add);

			if (hotels.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(hotels, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("hotel/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("id") Long id) {
		Optional<Hotel> hotelData = hotelRepository.findById(id);

		if (hotelData.isPresent()) {
			return new ResponseEntity<>(hotelData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
