package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for Comment class
 */
@RestController
@RequestMapping("/")
public class CommentController {

    /** Service for Company class */
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Get Comment by id
     * @param id : id of the searched post
     * @return comment found
     */
    @GetMapping("/comments/id/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        return ResponseEntity.ok().body(commentService.getById(id));
    }

    @PostMapping("/comments")
    public Comment createComment(@RequestBody String content) {
        return commentService.create(content);
    }
}
