package com.makersacademy.acebook.service;
import com.makersacademy.acebook.model.Like;

public interface ILikeService {
  Boolean userLikedPost(Long user_id, Long post_id);
  Boolean save(Like like);
}
