package com.nankiewic.lareservation.Service;

import com.nankiewic.lareservation.Entity.Reservation;
import com.nankiewic.lareservation.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    ReservationRepository reservationRepository;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Optional<Reservation> findById(Long index) {
        return reservationRepository.findById(index);
    }

    public Iterable<Reservation> findByCustomerId(Long id) {
        return reservationRepository.findByCustomerFk(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteById(Long index) {
        reservationRepository.deleteById(index);
    }
}
