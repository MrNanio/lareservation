package com.nankiewic.lareservation.Controller;

import com.nankiewic.lareservation.Entity.Customer;
import com.nankiewic.lareservation.Entity.Host;
import com.nankiewic.lareservation.Entity.User;
import com.nankiewic.lareservation.Security.UserDetailsImpl;
import com.nankiewic.lareservation.Service.HostService;
import com.nankiewic.lareservation.Service.ReservationService;
import com.nankiewic.lareservation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/host")
public class HostController {
    UserService userService;
    HostService hostService;
    @Autowired
    public HostController(UserService userService, HostService hostService) {
        this.userService = userService;
        this.hostService = hostService;
    }

    @PostMapping("/set")
    public Host setHost(Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        User user=userService.findByEmail(userPrincipal.getEmail());
        Host host=new Host();
        host.setUser(user);
        host.setStatus(true);
        return hostService.save(host);
    }
}
