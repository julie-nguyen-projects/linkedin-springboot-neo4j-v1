package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
import com.epitech.linkedinspringbootneo4jv1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

/**
 * Controller for Post class
 */
@RestController
@RequestMapping("/")
public class PostController {

    /** Service for Post class */
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Get all comment linked to a post
     * @param id : the id of the post we are looking for comments
     * @return :  status OK and list of Comment for a Post in the body
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

    /**
     * Create a Post
     * @param content : post to create
     * @return post created
     */
    @PostMapping("/posts")
    public Post createPost(@RequestBody String content) {
        return postService.create(content);
    }

    /**
     * Update a Post
     * @param id : id of the post
     * @return post update
     */
    @PutMapping("/posts/id/{id}")
    public Post updatePost(@PathVariable("id") Long id, @RequestBody Post post) { return this.postService.updatePost(id, post); }

    /**
     * Delete a Post
     * @param id : id of the post
     */
    @DeleteMapping("/posts/id/{id}")
    public void deletePost(@PathVariable("id") Long id) { this.postService.deletePost(id); }
}
