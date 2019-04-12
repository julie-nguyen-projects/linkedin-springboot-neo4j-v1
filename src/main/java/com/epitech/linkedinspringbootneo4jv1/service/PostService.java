package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
import com.epitech.linkedinspringbootneo4jv1.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Service for Post class
 */
@Service
public class PostService {
    /** Repository for post class */
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
     * @param id : id of the searched post
     * @return post found
     */
    public Post getById(Long id) {
        return postRepository.getPostById(id);
    }


    /**
     * Get comments by post
     * @param id : id of the searched Post
     * @return list of the comment(s) found
     */
    public Collection<Comment> getPostComments(Long id) {
        return postRepository.getPostComments(id);
    }



    public Post create(String content) {
        return postRepository.createPost(content);
    }


    /**
     * Update an existed post with a given id.
     * The function add a new post if it doesn't exist.
     * @param postId
     * @param post
     * @return
     */
    public Post updatePost(Long postId, Post post) {
        Post existingPost = this.getById(postId);
        if (existingPost != null) {
            existingPost.setContent(post.getContent());
            this.postRepository.save(existingPost);
        }
        return this.postRepository.save(existingPost);
    }

    /**
     * Delete a post with the given id
     * @param id the id of the post
     */
    public void deletePost(Long id) {
        this.postRepository.deleteById(id);
    }

}
