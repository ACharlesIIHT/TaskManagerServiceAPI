package com.taskmgr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taskmgr.model.Parent;

@Repository
public interface ParentTaskRepository extends CrudRepository<Parent, Integer> {

}
