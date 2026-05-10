package CollaboTodo.Service;

import CollaboTodo.Entity.Todo;
import CollaboTodo.Repository.TodoRepository;
import CollaboTodo.dto.TodoRequestDto;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodo(){
        return todoRepository.findAll();
    }

    public Todo createTodo(TodoRequestDto requestDto){
        Todo todo = new Todo();

        todo.setContent(requestDto.getContent());
        todo.setCompleted(false);

        LocalDate date = LocalDate.now();
        todo.setCurrent_t(date); // 현재 날짜 생성
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, TodoRequestDto todoRequestDto){
        Todo todo = todoRepository.findById(id).orElseThrow();

        todo.setContent(todoRequestDto.getContent());
        todo.setCompleted(todoRequestDto.isCompleted());
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id){
//        Todo todo = todoRepository.findById(id).orElseThrow();
//
//        todoRepository.delete(todo);

        todoRepository.deleteById(id);
    }

}
