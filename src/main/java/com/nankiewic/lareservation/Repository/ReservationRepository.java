package com.nankiewic.lareservation.Repository;

import com.nankiewic.lareservation.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation, Long> {
}
