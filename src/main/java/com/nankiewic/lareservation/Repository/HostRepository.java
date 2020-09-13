package com.nankiewic.lareservation.Repository;

import com.nankiewic.lareservation.Entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
    @Query("select h from Host h where h.user = ?1")
    Host findByUserFk(Long id);
}
