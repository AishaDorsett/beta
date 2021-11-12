package com.makersacademy.acebook.service;
import com.makersacademy.acebook.model.Like;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.makersacademy.acebook.repository.LikeRepository;

@Service
public class LikeService implements ILikeService{
  @Autowired
  private LikeRepository repository;

  @Override
  public Boolean save(Like like){
    if(userLikedPost(like.user_id, like.post_id)){
      return false;
    }
    repository.save(like);
    return true;
  }

  @Override
  public Boolean userLikedPost(Long user_id, Long post_id){
    return repository.userLikedPost(user_id, post_id);
  }
  
}
