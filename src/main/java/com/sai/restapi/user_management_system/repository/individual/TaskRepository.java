package com.sai.restapi.user_management_system.repository.individual;

import com.sai.restapi.user_management_system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
