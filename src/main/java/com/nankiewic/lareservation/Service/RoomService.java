package com.nankiewic.lareservation.Service;

import com.nankiewic.lareservation.Entity.Room;
import com.nankiewic.lareservation.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RoomService {
    RoomRepository roomRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Iterable <Room>findAll(){
        return roomRepository.findAll();
    }

    public Optional<Room> findById(Long index) {
        return roomRepository.findById(index);
    }

    public Room save(Room room) {
       return roomRepository.save(room);
    }

    public void deleteById(Long index) {
        roomRepository.deleteById(index);
    }
}
