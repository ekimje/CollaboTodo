package CollaboTodo.Controller;

import CollaboTodo.Entity.Todo;
import CollaboTodo.Service.TodoService;
import CollaboTodo.UI.TodoCalendar;
import CollaboTodo.dto.TodoDateResponseDto;
import CollaboTodo.dto.TodoRequestDto;
import org.springframework.format.annotation.DateTimeFormat;
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

    @GetMapping(params = "date")
    public TodoDateResponseDto getTodoByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date){
        return new TodoDateResponseDto(date, todoService.getTodoListByDate(date));
    }

    @GetMapping("/date/{date}")
    public List<Todo> getTodoDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date){
        return todoService.getTodoListByDate(date);
    }

    @GetMapping("/date/{date}/previous")
    public TodoDateResponseDto getPreviousDateTodos(@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date){
        LocalDate previousDate = date.minusDays(1);
        return new TodoDateResponseDto(previousDate, todoService.getPreviousDateTodoList(date));
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
