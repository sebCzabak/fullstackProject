package com.sebCzabak.fullstackProject.model.tasks;

import com.sebCzabak.fullstackProject.model.Employee;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @SequenceGenerator(
            name="task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"

    )
    private Long id;
    private String todos;

    private String description;
    private boolean done=false;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    public Task() {
    }

    public Task( String description, boolean done,String todos) {
        this.description = description;
        this.done = done;
        this.todos =todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", todos='" + todos + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", employee=" + employee +
                '}';
    }
}
