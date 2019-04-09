package com.epitech.linkedinspringbootneo4jv1.repository;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface PostRepository extends Neo4jRepository<Post, Long> {

    /**
     * Get all post
     * @return list of companies
     */
    @Query("MATCH (c:Post) MATCH p=(c)-[r*0..2]-() RETURN c, nodes(p), rels(p)")
    Collection<Post> getAllPost();

    /**
     * Get post by id
     * @param id : id of the searched post
     * @return post found
     */
    @Query("MATCH p=(c:Post)-[r*0..2]-() WHERE ID(c)={id} RETURN c, nodes(p), rels(p)")
    Post getPostById(Long id);


    /**
     * Get post by id
     * @param id : id of the searched post
     * @return comments found
     */
    @Query("MATCH (e:Comment)<-[he:HAS_COMMENTS]-(u:Post) " +
            "WHERE ID(u)={id} " +
            "RETURN e,he,u")
    Collection<Comment> getPostComments(Long id);


    @Query("MATCH (city {name: {cityName}})" +
            "CREATE (post:Post {content: {content}}) " +
           " RETURN post")
    Post createPost(String content);

    /**
     * Create a Comment
     * @param content : Content of Comment
     * @return : created Comment
     */
    @Query("CREATE (comment:Comment {content: {content}})")
    Comment createComment(String content);
}
