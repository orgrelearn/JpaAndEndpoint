package com.realm.relearn.repositories;


import com.realm.relearn.model.Comment;
import com.realm.relearn.model.Post;
import com.realm.relearn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
    // only a user can make a comment
    List<Comment> findAllByUser(User user);
}