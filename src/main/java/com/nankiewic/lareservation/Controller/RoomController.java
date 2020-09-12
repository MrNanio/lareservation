package com.nankiewic.lareservation.Controller;

import com.nankiewic.lareservation.Entity.Room;
import com.nankiewic.lareservation.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {
    RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room){
       return roomService.save(room);
    }
    @PutMapping
    public Room updateRoom(@RequestBody Room room){
        return roomService.save(room);
    }
    @DeleteMapping
    public void deleteRoom(@RequestParam Long index){
       roomService.deleteById(index);
    }
    @GetMapping("/all")
    public Iterable<Room> getAllRoom(){
        return roomService.findAll();

    }
    @GetMapping
    public Optional<Room> getById(@RequestParam Long index){
        return roomService.findById(index);
    }
    //---------------------------------------//
    @PostMapping("/cancel")
    public String cancelRoom(){
        return "ok";
    }




}
