package com.nankiewic.lareservation.Controller;

import com.nankiewic.lareservation.Entity.Host;
import com.nankiewic.lareservation.Entity.Room;
import com.nankiewic.lareservation.Entity.User;
import com.nankiewic.lareservation.Security.UserDetailsImpl;
import com.nankiewic.lareservation.Service.HostService;
import com.nankiewic.lareservation.Service.RoomService;
import com.nankiewic.lareservation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {
    RoomService roomService;
    UserService userService;
    HostService hostService;
    @Autowired
    public RoomController(RoomService roomService, UserService userService, HostService hostService) {
        this.roomService = roomService;
        this.userService = userService;
        this.hostService = hostService;
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room, Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        User user=userService.findByEmail(userPrincipal.getEmail());
        Host host=hostService.findByUserFk(user.getId());
        room.setHost(host);
        return roomService.save(room);
    }
    @PutMapping
    public Room updateRoom(@RequestBody Room room){
        return roomService.save(room);
    }
    @DeleteMapping
    public void deleteRoom(@RequestParam Long index, Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        User user=userService.findByEmail(userPrincipal.getEmail());
        Host host=hostService.findByUserFk(user.getId());
        Room room= roomService.findById(index).get();
        if(room.getHost().getId().equals(host.getId())){
            roomService.deleteById(index);
        }
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
