package com.social.media.platform;

import com.social.media.platform.models.Post;
import com.social.media.platform.models.SocialGroup;
import com.social.media.platform.models.SocialProfile;
import com.social.media.platform.models.SocialUser;
import com.social.media.platform.repositories.GroupRepo;
import com.social.media.platform.repositories.PostRepo;
import com.social.media.platform.repositories.SocialProfileRepo;
import com.social.media.platform.repositories.SocialUserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    private final SocialUserRepo socialUserRepo;
    private final GroupRepo groupRepo;
    private final SocialProfileRepo socialProfileRepo;
    private final PostRepo postRepo;

    public DataInitializer(SocialUserRepo socialUserRepo, GroupRepo groupRepo, SocialProfileRepo socialProfileRepo, PostRepo postRepo) {
        this.socialUserRepo = socialUserRepo;
        this.groupRepo = groupRepo;
        this.socialProfileRepo = socialProfileRepo;
        this.postRepo = postRepo;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return (args -> {
            // Create and save users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            socialUserRepo.save(user1);
            socialUserRepo.save(user2);
            socialUserRepo.save(user3);

            // Create groups and assign users to groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2); // ✅ user2 in both groups
            group2.getSocialUsers().add(user3); // ✅ user3 in group2

            groupRepo.save(group1);
            groupRepo.save(group2);

            // Assign groups to users (keep both sides of the relationship in sync)
            user1.getGroups().add(group1);
            user2.getGroups().add(group1);
            user2.getGroups().add(group2); // ✅ user2 in both groups
            user3.getGroups().add(group2); // ✅ fixed: was user1, should be user3

            socialUserRepo.save(user1);
            socialUserRepo.save(user2);
            socialUserRepo.save(user3); // ✅ fixed: user3 was missing

            // Create posts and link to users
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            postRepo.save(post1);
            postRepo.save(post2);
            postRepo.save(post3);

            // Create profiles and link to users
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            user1.setSocialProfile(profile1);
            user2.setSocialProfile(profile2);
            user3.setSocialProfile(profile3);

            socialProfileRepo.save(profile1);
            socialProfileRepo.save(profile2);
            socialProfileRepo.save(profile3);

//            Fetch Types
            System.out.println("FETCHING SOCIAL USER");
            socialUserRepo.findById(1L);
        });
    }
}