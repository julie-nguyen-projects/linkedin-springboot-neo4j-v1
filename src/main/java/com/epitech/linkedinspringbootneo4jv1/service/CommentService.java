package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
import com.epitech.linkedinspringbootneo4jv1.repository.CompanyRepository;
import com.epitech.linkedinspringbootneo4jv1.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Collection;

/**
 * Service for Post class
 */
@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Get all Post
     * @return list of companies
     */
    public Collection<Post> getAll() {
        return postRepository.getAllPost();
    }

    /**
     * Get Post by id
     * @param id : id of the searched Post
     * @return post found
     */
    public Post getById(Long id) {
        return postRepository.getPostById(id);
    }


    /**
     * Get comments by postId
     * @param id : id of the searched Post
     * @return post found
     */
    public Collection<Comment> getPostComments(Long id) {
        return postRepository.getPostComments(id);
    }



    public Post create(String content) {
        return postRepository.createPost(content);
    }

}
