package com.realm.relearn.services.interfaces;

import com.realm.relearn.model.Post;
import com.realm.relearn.repositories.PostRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface PostService {
    public List<Post> getPostList(int page, int size);
    public List<Post> getAllPosts();
    public List<Post> getPostByTitleContaining(String title,int page , int size);
    public void deletePostById(Long id);

    void savePost(Post post);
    void updatePost(Post post);
}
