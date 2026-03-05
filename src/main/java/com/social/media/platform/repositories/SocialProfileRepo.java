package com.social.media.platform.repositories;

import com.social.media.platform.models.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialProfileRepo extends JpaRepository<SocialProfile, Long> {
}
