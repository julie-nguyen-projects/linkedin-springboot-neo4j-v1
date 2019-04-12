package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.repository.CommentRepository;
import org.springframework.stereotype.Service;

/**
 * Service for Comment class
 */
@Service
public class CommentService {

    /** Repository for comment class */
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * Get comment by id
     * @param id : id of the searched comment
     * @return comment found
     */
    public Comment getById(Long id) {
        return commentRepository.getCommentByID(id);
    }

    /**
     * Create a comment
     * @param content : content of the comment
     * @return comment created
     */
    public Comment create(String content) {
        return commentRepository.createComment(content);
    }

}
