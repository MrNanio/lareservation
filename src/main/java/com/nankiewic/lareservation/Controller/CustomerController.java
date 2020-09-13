package com.nankiewic.lareservation.Controller;

import com.nankiewic.lareservation.Entity.Customer;
import com.nankiewic.lareservation.Entity.User;
import com.nankiewic.lareservation.Security.UserDetailsImpl;
import com.nankiewic.lareservation.Service.CustomerService;
import com.nankiewic.lareservation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    UserService userService;
    CustomerService customerService;
    @Autowired
    public CustomerController(UserService userService, CustomerService customerService) {
        this.userService = userService;
        this.customerService = customerService;
    }

    @PostMapping("/set")
    public Customer setCustomer(Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        User user=userService.findByEmail(userPrincipal.getEmail());
        Customer customer=new Customer();
        customer.setUser(user);
        customer.setStatus(true);
        return customerService.save(customer);
    }

}
