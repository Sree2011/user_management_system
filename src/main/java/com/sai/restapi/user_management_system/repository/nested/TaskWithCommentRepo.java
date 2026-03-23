package com.sai.restapi.user_management_system.repository.nested;


import com.sai.restapi.user_management_system.model.Comment;
import com.sai.restapi.user_management_system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskWithCommentRepo extends JpaRepository<Task,Integer> {

    // Fetch all tasks assigned to a given user
    @Query("SELECT c FROM Comment c WHERE c.task.task_id = :taskId")
    List<Comment> findAllCommentsForTask(@Param("taskId") Integer taskId);


    //Assign task to a user
    @Query("SELECT t FROM Task t LEFT JOIN FETCH t.comments")
    List<Task> getAllTasksAndComments();
}
