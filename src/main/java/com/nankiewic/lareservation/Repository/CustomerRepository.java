package com.nankiewic.lareservation.Repository;

import com.nankiewic.lareservation.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.user = ?1")
    Customer findByUserFk(Long id);
}
