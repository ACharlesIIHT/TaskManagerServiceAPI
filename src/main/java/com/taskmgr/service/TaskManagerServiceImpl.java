package com.taskmgr.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.taskmgr.model.Parent;
import com.taskmgr.model.Task;
import com.taskmgr.repository.ParentTaskRepository;
import com.taskmgr.repository.TaskRepository;

@Service
public class TaskManagerServiceImpl implements TaskManagerService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ParentTaskRepository ParentTaskRepository;

	@Override
	public List<Task> getAllTasks() {
		return (List<Task>) this.taskRepository.findAll();
	}

	@Override
	public Task saveTask(Task task) {
		return this.taskRepository.save(task);
	}

	@Override
	public Task getTaskById(String id) {
		Optional<Task> opTask = this.taskRepository.findById(Integer.parseInt(id));
		if (!opTask.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return opTask.get();
	}

	@Override
	public Task endTask(String taskId) {
		Task task = getTaskById(taskId);
		LocalDate currentDate = LocalDate.now();
		task.setEndDate(currentDate);
		Optional<Parent> parent = this.ParentTaskRepository.findById(task.getId());
		if (parent.isPresent()) {
			parent.get().getTasks().forEach(t -> {
				t.setEndDate(currentDate);
				this.taskRepository.save(t);
			});
		}
		return this.taskRepository.save(task);
	}

}
