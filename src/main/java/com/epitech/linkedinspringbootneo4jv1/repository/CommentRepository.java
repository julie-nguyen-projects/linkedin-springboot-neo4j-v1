package com.epitech.linkedinspringbootneo4jv1.repository;

import com.epitech.linkedinspringbootneo4jv1.model.Comment;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CommentRepository extends Neo4jRepository<Post, Long> {

    /**
     * Get comment by id
     * @param id : id of the searched comment
     * @return comment found
     */
    @Query("MATCH (s:Comment) WHERE ID(s)={id} RETURN s")
    Comment getCommentByID(Long id);

    /**
     * Create a comment
     * @param content : content of the comment
     * @return : created Comment
     */
    @Query("CREATE (comment:Comment {content: {content}})")
    Comment createComment(String content);
}
