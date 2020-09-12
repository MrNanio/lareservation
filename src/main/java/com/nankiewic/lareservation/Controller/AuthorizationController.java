package com.nankiewic.lareservation.Controller;

import com.nankiewic.lareservation.Entity.User;
import com.nankiewic.lareservation.Security.Payload.AuthenticationRequest;
import com.nankiewic.lareservation.Security.Payload.AuthenticationResponse;
import com.nankiewic.lareservation.Security.Payload.MessageResponse;
import com.nankiewic.lareservation.Security.TokenUtility;
import com.nankiewic.lareservation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class AuthorizationController {
    AuthenticationManager authenticationManager;
    UserService userService;
    PasswordEncoder encoder;
    TokenUtility tokenUtility;
    @Autowired
    public AuthorizationController(AuthenticationManager authenticationManager, UserService userService, PasswordEncoder encoder, TokenUtility tokenUtility) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.encoder = encoder;
        this.tokenUtility = tokenUtility;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt= tokenUtility.generateJwtToken(authentication);
        User user=userService.findByEmail(authenticationRequest.getEmail());
        user.setLastLoginAt(LocalDateTime.now());
        userService.update(user);
       return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<MessageResponse> registerUser(@RequestBody AuthenticationRequest authenticationRequest) {
        if (userService.existsByEmail(authenticationRequest.getEmail())) {
            ResponseEntity.status(404);
        }
        User user = new User(authenticationRequest.getEmail(), encoder.encode(authenticationRequest.getPassword()));
        userService.register(user);
        return ResponseEntity.ok(new MessageResponse("OK", LocalDateTime.now()));
    }

}
