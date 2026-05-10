package CollaboTodo.Service;

import CollaboTodo.Entity.Todo;
import CollaboTodo.Repository.TodoRepository;
import CollaboTodo.dto.TodoRequestDto;
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
        todo.setCompleted(requestDto.isCompleted());
        todo.setDueDate(requestDto.getDueDate());
        todo.setCreatedAt(LocalDate.now());

        return todoRepository.save(todo);
    }
    
    // 조회 날짜 제공
    public List<Todo> getTodoListByDate(LocalDate date){
        return todoRepository.findByDueDate(date);
    }


    public Todo updateTodo(Long id, TodoRequestDto todoRequestDto){
        Todo todo = todoRepository.findById(id).orElseThrow();

        todo.setContent(todoRequestDto.getContent());
        todo.setCompleted(todoRequestDto.isCompleted());
        todo.setDueDate(todoRequestDto.getDueDate());
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

}
