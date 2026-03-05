package com.social.media.platform.repositories;

import com.social.media.platform.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
