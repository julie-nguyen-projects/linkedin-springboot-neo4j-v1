package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
import com.epitech.linkedinspringbootneo4jv1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

//    /**
//     * Get all companies
//     * @return ResponseEntity : status OK and list of companies in the body
//     */
//    @GetMapping("/companies")
//    public ResponseEntity<Collection<Comment>> getAll() {
//        return ResponseEntity.ok().body(commentService.getAll());
//    }

    @PostMapping("/comments")
    public Comment createComment(@RequestBody String content) {
        return commentService.create(content);
    }
}
