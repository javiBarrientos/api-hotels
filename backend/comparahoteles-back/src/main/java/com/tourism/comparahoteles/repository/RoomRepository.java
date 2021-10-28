package com.tourism.comparahoteles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.comparahoteles.models.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
