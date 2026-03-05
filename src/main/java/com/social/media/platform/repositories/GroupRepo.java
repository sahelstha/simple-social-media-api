package com.social.media.platform.repositories;

import com.social.media.platform.models.SocialGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<SocialGroup, Long> {
}
