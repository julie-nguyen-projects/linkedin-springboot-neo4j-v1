package com.epitech.linkedinspringbootneo4jv1.repository;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface CommentRepository extends Neo4jRepository<Post, Long> {

    /**
     * Get all post
     * @return list of companies
     */
    //@Query("MATCH (c:Comment) MATCH p=(c)-[r*0..2]-() RETURN c, nodes(p), rels(p)")
    @Query("MATCH (s:Comment) WHERE ID(s)={id} RETURN s")
    Comment getCommentByID(Long id);

    /**
     * Create a Comment
     * @param content : Content of Comment
     * @return : created Comment
     */
    @Query("CREATE (comment:Comment {content: {content}})")
    Comment createComment(String content);
}
