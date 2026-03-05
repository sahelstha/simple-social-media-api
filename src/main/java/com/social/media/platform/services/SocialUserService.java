package com.social.media.platform.services;

import com.social.media.platform.models.SocialUser;
import com.social.media.platform.repositories.SocialUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialUserService {
    @Autowired
    SocialUserRepo socialUserRepo;
    public List<SocialUser> getAllUsers() {
        return socialUserRepo.findAll();
    }

    public SocialUser saveUsers(SocialUser socialUser) {
        return socialUserRepo.save(socialUser);
    }

    public SocialUser deleteUser(Long id) {
        SocialUser socialUser = socialUserRepo.findById(id).orElseThrow(()-> new RuntimeException(" User Not Found"));
        socialUserRepo.delete(socialUser);
        return socialUser;
    }
}
