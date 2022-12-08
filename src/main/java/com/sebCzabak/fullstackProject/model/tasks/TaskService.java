package com.sebCzabak.fullstackProject.model.tasks;

import com.sebCzabak.fullstackProject.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private final TaskRepository taskRepository;
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task task) {
        Optional<Task>taskUpdate=taskRepository.findAll()
                .stream()
                .filter(item-> item.getId().equals(id))
                .findAny();
        if(taskUpdate.isPresent()){
            Task item = taskUpdate.get();
            item.setDone(task.isDone());
            return item;
        }
        return null;
    }

    public void createTask(Task task) {

        task.setDone(false);
        task.setDescription(task.getDescription());
        taskRepository.save(task);

    }


    public void deleteTodo(Long id) {
        boolean exists = taskRepository.existsById(id);
        if(!exists){
            throw new UserNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
}
