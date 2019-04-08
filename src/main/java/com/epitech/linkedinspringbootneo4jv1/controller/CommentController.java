package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.Company;
import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
import com.epitech.linkedinspringbootneo4jv1.service.CompanyService;
import com.epitech.linkedinspringbootneo4jv1.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Controller for Company class
 */
@RestController
@RequestMapping("/")
public class PostController {

    /** Service for Company class */
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Get all companies
     * @return ResponseEntity : status OK and list of companies in the body
     */
    @GetMapping("/companies")
    public ResponseEntity<Collection<Post>> getAll() {
        return ResponseEntity.ok().body(postService.getAll());
    }


    /**
     * Get all comment linked to a post
     * @param id : id of the user
     * @return : comment of the post
     */
    @GetMapping("/posts/{id}/comments")
    public Collection<Comment> getPostComments(@PathVariable Long id) {
        return postService.getPostComments(id);
    }

    /**
     * Get Post by id
     * @param id : id of the searched post
     * @return post found
     */
    @GetMapping("/posts/id/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok().body(postService.getById(id));
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody String content) {
        return postService.create(content);
    }
}
