package com.nankiewic.lareservation.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @PostMapping("/add")
    public String addReservation(){
        return "ok";
    }
    @PostMapping("/change")
    public String updateReservation(){
        return "ok";
    }
    @PostMapping("/cancel")
    public String cancelReservation(){
        return "ok";
    }
    @GetMapping("/show")
    public String showAllReservation(){
        return "ok";
    }
    @DeleteMapping("/delete")
    public String deleteReservation(){
        return "ok";
    }

}
