package com.social.media.platform.repositories;

import com.social.media.platform.models.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepo extends JpaRepository<SocialUser, Long> {
}
