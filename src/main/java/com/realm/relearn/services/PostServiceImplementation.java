package com.realm.relearn.services;

import com.realm.relearn.dto.PostRequest;
import com.realm.relearn.dto.PostResponse;
import com.realm.relearn.model.Post;
import com.realm.relearn.repositories.PostRepository;
import com.realm.relearn.repositories.UserRepository;
import com.realm.relearn.services.interfaces.PostService;
import com.realm.relearn.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;

@Service
@Transactional
@AllArgsConstructor

/*
A Page<T> instance, in addition to having the list of Products, also knows about the total number of available pages. It triggers an additional count query to achieve it. To avoid such an overhead cost, we can instead return a Slice<T> or a List<T>.
 A Slice only knows whether the next slice is available or not.
 */


public class PostServiceImplementation implements PostService {
    @Autowired
    private final PostRepository postRepository;



    @Override
    public List<Post> getPostList(int page, int size){
        Pageable pageRequest= PageRequest.of(page, size);
        Page<Post> posts = postRepository.findAll(pageRequest);
        return posts.getContent();
    }

    @Override
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @Override
    public List<Post> getPostByTitleContaining(String title, int page, int size) {
        Pageable pageRequest= PageRequest.of(page, size);
        Page<Post> postContainingTheTitle = postRepository.findByTitleContaining(title, pageRequest);
        return postContainingTheTitle.getContent();
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deletePostById(id);
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void updatePost(Post post) {
        postRepository.save(post);
    }

//    private PostResponse convertToPostResponse(Post post) {
//        PostResponse postResponse = modelMapper.map(post, PostResponse.class);
//        postResponse.setCreationDate(java.util.Date.from(post.getCreated().atStartOfDay()
//                .atZone(ZoneId.systemDefault())
//                .toInstant()), "UTC");
//        return postResponse;
//    }
}
