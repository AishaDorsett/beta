package com.makersacademy.acebook.repository;

import java.util.List;

import com.makersacademy.acebook.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("FROM Post ORDER BY created_at DESC")
    List<Post> findAllOrderByDateDesc();
    
    // @Query("SELECT COUNT(l) FROM Post p JOIN liked_posts l ON l.post_id = p.id WHERE l.post_id=?1")
    // Integer countLikes(Integer post_id);


}
