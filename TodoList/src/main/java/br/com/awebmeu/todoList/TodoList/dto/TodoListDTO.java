package br.com.awebmeu.todoList.TodoList.dto;

public class TodoListDTO {

    private Long id;
    private String description;
    private String priority;
    private String status;

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
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public TodoListDTO(Long id, String description, String priority, String status) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }
    public TodoListDTO() {
    }
    public TodoListDTO(String description, String priority, String status) {
        this.description = description;
        this.priority = priority;
        this.status = status;
    }
    

    
}
