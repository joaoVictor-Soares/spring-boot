package br.com.awebmeu.todoList.TodoList.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.awebmeu.todoList.TodoList.dto.TodoListDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/todo")
public class TodoListController {
    
    // Guarda as tarefas na memória (mapa: ID -> tarefa)
    private Map<Long, TodoListDTO> todo = new HashMap<>();  
    // Próximo ID disponível
    private Long nextId = 1L;

    @PostMapping("/add")
    public TodoListDTO createTask(@RequestBody TodoListDTO entity) {
        // Dá um ID, marca como 'Em andamento', salva e retorna
        entity.setId(nextId++);
        entity.setStatus("Em andamento");
        todo.put(entity.getId(), entity);
        return entity;
    }
    

    @GetMapping("/filter")
    public List<TodoListDTO> filterByPriority(@RequestParam String priority) {
        // Se veio prioridade, mostra só as tarefas dessa prioridade; senão, mostra todas
        if (priority != null) {
            return todo.values().stream()
                .filter(t -> t.getPriority().equalsIgnoreCase(priority))
                .toList();
        }
        return new ArrayList<>(todo.values());
    }

    @GetMapping("/test")
    public List<TodoListDTO> allTasks() {
        // Lista todas as tarefas
        return new ArrayList<>(todo.values());
    }

    @PutMapping("put/{id}")
    public TodoListDTO puTodoListDTO(@PathVariable Long id, @RequestBody TodoListDTO status ) {
        // Muda só o status da tarefa com o `id` informado
        if (status != null && todo.containsKey(id)) {
            todo.get(id).setStatus(status.getStatus());
        }
        return status;
    }
    
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        // Remove a tarefa e devolve uma mensagem simples
        if (todo.remove(id) != null) {
            return "Produto removido";
        }
        return "Produto Inexistente";
    }
    

}
