package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
  @Query(value="SELECT EXISTS(SELECT 1 FROM liked_posts WHERE user_id=?1 AND post_id=?2)", nativeQuery=true)
  boolean userLikedPost(Long user_id, Long post_id);

}