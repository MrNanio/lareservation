package com.nankiewic.lareservation.Service;

import com.nankiewic.lareservation.Entity.Customer;
import com.nankiewic.lareservation.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
       return customerRepository.save(customer);
    }

    public Customer findByUserFk(Long id) {
       return customerRepository.findByUserFk(id);
    }
}
