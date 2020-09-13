package com.nankiewic.lareservation.Repository;

import com.nankiewic.lareservation.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository <Reservation, Long> {
    @Query("select r from Reservation r where r.customer = ?1")
    Iterable<Reservation> findByCustomerFk(Long id);
}
