package com.realm.relearn.controller;

import com.realm.relearn.dto.PostResponse;
import com.realm.relearn.services.PostServiceImplementation;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private PostServiceImplementation postServiceImplementation;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping(path="/{page}", produces = "application/json")
    public ResponseEntity<List<PostResponse>> getPostsByPageAndSize(@PathVariable("page") int page, @RequestParam("size") int size){
        List<PostResponse> postsByPagAndSize = postServiceImplementation.getPostList(page, size).stream()
                .map(post -> modelMapper.map(post,PostResponse.class))
                .collect(Collectors.toList());
        return status(HttpStatus.OK).body(postsByPagAndSize);
    }
    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<List<PostResponse>> getAllPost(){
        List<PostResponse> allPost = postServiceImplementation.getAllPosts().stream()
                .map(post -> modelMapper.map(post,PostResponse.class))
                .collect(Collectors.toList());
        return status(HttpStatus.OK).body(allPost);
    }


}
