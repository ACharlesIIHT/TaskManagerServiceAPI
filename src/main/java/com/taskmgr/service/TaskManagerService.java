package com.taskmgr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmgr.model.Task;

@Service
public interface TaskManagerService {

	List<Task> getAllTasks();

	Task saveTask(Task task);

	Task getTaskById(String id);

	Task endTask(String taskId);
}
