package CollaboTodo.Controller;

import CollaboTodo.Entity.Todo;
import CollaboTodo.Service.TodoService;
import CollaboTodo.UI.TodoCalendar;
import CollaboTodo.dto.TodoRequestDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/date/{date}")
    public List<Todo> getTodoDate(@PathVariable LocalDate date){
        return todoService.getTodoListByDate(date);
    }

    @GetMapping("/calendar")
    public String calendar(){
        TodoCalendar cal = new TodoCalendar();
        return cal.printCalendar();
    }

    @PostMapping
    public Todo createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        return todoService.createTodo(todoRequestDto);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto todoRequestDto){
        return todoService.updateTodo(id,todoRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }
}
