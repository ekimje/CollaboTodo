package CollaboTodo.Service;

import CollaboTodo.Entity.Todo;
import CollaboTodo.Repository.TodoRepository;
import CollaboTodo.dto.TodoRequestDto;
import org.springframework.stereotype.Service;

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
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow();

        todo.setCompleted(true);
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id){
//        Todo todo = todoRepository.findById(id).orElseThrow();
//
//        todoRepository.delete(todo);

        todoRepository.deleteById(id);
    }

}
