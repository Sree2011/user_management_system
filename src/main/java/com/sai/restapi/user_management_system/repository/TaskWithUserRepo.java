package com.sai.restapi.user_management_system.repository;
import com.sai.restapi.user_management_system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskWithUserRepo extends JpaRepository<Task, Integer> {


        // Fetch all tasks assigned to a given user
        @Query("SELECT t FROM Task t WHERE t.user.user_id = :userId")
        List<Task> findAllTasksForUser(@Param("userId") Integer userId);


        //Assign task to a user



}