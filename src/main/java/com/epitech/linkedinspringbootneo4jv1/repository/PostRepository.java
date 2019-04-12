package com.epitech.linkedinspringbootneo4jv1.repository;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.Collection;

public interface PostRepository extends Neo4jRepository<Post, Long> {

    /**
     * Get all post
     * @return list of post
     */
    @Query("MATCH (c:Post) MATCH p=(c)-[r*0..2]-() RETURN c, nodes(p), rels(p)")
    Collection<Post> getAllPost();

    /**
     * Get post by id
     * @param id : id of the searched post
     * @return post found
     */
    @Query("MATCH (s:Post) WHERE ID(s)={id} RETURN s")
    Post getPostById(Long id);

    /**
     * Get a list of comment by a post id
     * @param id : id of the searched post
     * @return list of comments found
     */
    @Query("MATCH (e:Comment)<-[he:HAS_COMMENTS]-(u:Post) " +
            "WHERE ID(u)={id} " +
            "RETURN e,he,u")
    Collection<Comment> getPostComments(Long id);

    /**
     * Create a post
     * @param content : Content of post
     * @return : created post
     */
    @Query("MATCH (city {name: {cityName}})" +
            "CREATE (post:Post {content: {content}}) " +
           " RETURN post")
    Post createPost(String content);

    /**
     * Delete a post
     * @param id : id of the post
     */
    void deleteById(Long id);
}
