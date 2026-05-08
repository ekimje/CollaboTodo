package CollaboTodo.Controller;

import CollaboTodo.Entity.Todo;
import CollaboTodo.Service.TodoService;
import CollaboTodo.dto.TodoRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodo() {
        return todoService.getTodo();
    }

    @PostMapping
    public Todo createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        return todoService.createTodo(todoRequestDto);
    }
}
