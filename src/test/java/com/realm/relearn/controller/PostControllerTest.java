package com.realm.relearn.controller;

import com.realm.relearn.RelearnApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = RelearnApplication.class)
@AutoConfigureMockMvc
//The WebMvcTest annotation auto-configure MockMvc instance as well.
@WebMvcTest(PostController.class)
class PostControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void getPostsByPageAndSize() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .get("/posts")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts").exists());
    }

    @Test
    void getAllPost() {
    }
}