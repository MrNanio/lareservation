package com.nankiewic.lareservation.Repository;

import com.nankiewic.lareservation.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository <Room, Long>{
}
