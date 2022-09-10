package com.realm.relearn.repositories;

import com.realm.relearn.model.Post;
import com.realm.relearn.model.User;
import com.realm.relearn.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
;

import java.util.Optional;

@Repository


public interface VoteRepository extends JpaRepository<Vote, Long> {
    // to verify the functioning of this snippet
    Optional<Vote> findTopByPostAndUserOrderByIdDesc(Post post, User currentUser);
}