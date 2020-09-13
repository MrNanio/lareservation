package com.nankiewic.lareservation.Controller;

import com.nankiewic.lareservation.Entity.Customer;
import com.nankiewic.lareservation.Entity.Reservation;
import com.nankiewic.lareservation.Security.UserDetailsImpl;
import com.nankiewic.lareservation.Service.CustomerService;
import com.nankiewic.lareservation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    ReservationService reservationService;
    CustomerService customerService;
    @Autowired
    public ReservationController(ReservationService reservationService, CustomerService customerService) {
        this.reservationService = reservationService;
        this.customerService = customerService;
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation, Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        Customer customer=customerService.findByUserFk(userPrincipal.getId());
        reservation.setCustomer(customer);
        return reservationService.save(reservation);
    }
    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    @DeleteMapping
    public void deleteReservation(@RequestParam Long index){
        reservationService.deleteById(index);
    }
    @GetMapping("/all")
    public Iterable<Reservation> showAllReservation(Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        Customer customer=customerService.findByUserFk(userPrincipal.getId());
        return reservationService.findByCustomerId(customer.getId());
    }
    @GetMapping
    public Optional<Reservation> getById(@RequestParam Long index){
        return reservationService.findById(index);
    }
    //---------------------------------------------------------------------------------------
    @PostMapping("/cancel")
    public String cancelReservation(){
        return "ok";
    }
}
