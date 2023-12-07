package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.User;
import kr.ac.mjc.kiosk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;


}
