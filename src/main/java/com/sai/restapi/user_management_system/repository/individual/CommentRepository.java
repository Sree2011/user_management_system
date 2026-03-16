package com.sai.restapi.user_management_system.repository.individual;

import com.sai.restapi.user_management_system.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
