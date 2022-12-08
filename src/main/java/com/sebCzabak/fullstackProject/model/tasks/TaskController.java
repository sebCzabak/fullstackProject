package com.sebCzabak.fullstackProject.model.tasks;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = "/api")
public class TaskController {
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    private final TaskService taskService;

    @GetMapping("/todoItems")
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @PutMapping("/todoItems/setDone/{id}")
    public Task updateTask(@PathVariable Long id,
                           @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }
    @PostMapping("/todoItems/createTodo")
    public void createTask(@RequestBody Task task){
        taskService.createTask(task);
    }
    @DeleteMapping("/todoItems/deleteTodo/{id}")
    public void  deleteTodo(@PathVariable Long id){
        taskService.deleteTodo(id);
    }


}



