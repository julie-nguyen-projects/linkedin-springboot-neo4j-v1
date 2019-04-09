package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
