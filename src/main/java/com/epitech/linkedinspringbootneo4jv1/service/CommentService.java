package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
import com.epitech.linkedinspringbootneo4jv1.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Service for Post class
 */
@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * Get all Post
     * @return list of companies
     */
    public Collection<Comment> getAll() {
        return commentRepository.getAllComment();
    }


    public Comment create(String content) {
        return commentRepository.createComment(content);
    }

}
