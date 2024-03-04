package com.example.blog_api.repositories;

import com.example.blog_api.models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
