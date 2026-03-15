package com.sai.restapi.user_management_system.repository;

import com.sai.restapi.user_management_system.model.Project;
import com.sai.restapi.user_management_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWithProjectsRepo extends JpaRepository<User, Integer> {

    @Query("SELECT p from Project p where p.owner.user_id = :owner_id")
    List<Project> getAllProjectsForUser(@Param("owner_id") Integer userId);




}
