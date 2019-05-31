package com.taskmgr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taskmgr.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
