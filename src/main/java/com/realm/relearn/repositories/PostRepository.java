package com.realm.relearn.repositories;

import com.realm.relearn.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/*
JpaRepository extends PagingAndSortingRepository
we can find a set by multiple parameters findByXAndY / findByXOrY;
we can find a result by exclusion findByXNot;
findByTitleLike / findByTitleStartingBy / findByTitleContaining /findByPublishedTrue /List<Tutorial> findByCreatedAtAfter(Date date);
for case insensitive query findByTitleContainingIgnoreCas
*/
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    void deletePostById(Long id);
    Optional<Post> findPostById(Long id);
    Page<Post> findAll(Pageable pageable);
    Page<Post> findByTitleContaining(String title, Pageable pageable);
    List<Post> findAll();


}
