package com.social.media.platform.controllers;

import com.social.media.platform.models.SocialUser;
import com.social.media.platform.services.SocialUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
    private SocialUserService socialService;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getUsers() {
        System.out.println("fohjsa");
        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> saveUsers(@RequestBody SocialUser socialUser) {
        return new ResponseEntity<>(socialService.saveUsers(socialUser), HttpStatus.OK);
    }

}
