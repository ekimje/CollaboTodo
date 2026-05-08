package CollaboTodo.Controller;

import CollaboTodo.Service.TodoService;
import CollaboTodo.dto.TodoDto;
import CollaboTodo.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping
    public Todo create(@RequestBody TodoDto todoDto){
        return todoService.createTodo(todoDto.getTitle());
    }

    @GetMapping
    public List<Todo> findAll(){
        return todoService.
    }

}
