package com.nankiewic.lareservation.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/confirm_email")
    public String confirmEmail(){
        return "ok";
    }
    @PostMapping("/change_password")
    public String changePassword(){
        return "ok";
    }
    @PostMapping("/reset_password")
    public String resetPassword(){
        return "ok";
    }
    @PostMapping("/send_reset_email")
    public String sendResetEmail(){
        return "ok";
    }
    @GetMapping("/user_data")
    public String getUserData(){
        return "ok";
    }
}
