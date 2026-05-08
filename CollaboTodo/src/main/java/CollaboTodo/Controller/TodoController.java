package CollaboTodo.Controller;

import CollaboTodo.Entity.Todo;
import CollaboTodo.Service.TodoService;
import CollaboTodo.dto.TodoRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class TodoController {

    @PostMapping() // Todo 목록 조회.
    public Todo createTodo(@RequestBody TodoRequestDto todoRequestDto){
        return todoService.createTodo(todoRequestDto);
    }
}
