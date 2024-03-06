package com.example.blog_api.repositories;

import com.example.blog_api.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {
//    @Query("SELECT COUNT(*) FROM likes WHERE post_id = :post_id")
//    Long countLikesByPostId(@Param(":post_id") Long postId);
}
