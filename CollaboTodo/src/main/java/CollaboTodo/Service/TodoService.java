package CollaboTodo.Service;

import CollaboTodo.Entity.Todo;
import CollaboTodo.Repository.TodoRepository;
import CollaboTodo.dto.TodoRequestDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoService {
    private static final Sort TODO_SORT = Sort.by(
            Sort.Order.asc("dueDate"),
            Sort.Order.asc("completed"),
            Sort.Order.asc("id")
    );

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodo(){
        return todoRepository.findAll(TODO_SORT);
    }

    public Todo createTodo(TodoRequestDto requestDto) {
        Todo todo = new Todo();
        applyTodoRequest(todo, requestDto);
        todo.setCreatedAt(LocalDate.now());

        return todoRepository.save(todo);
    }
    // 조회 날짜 제공
    public List<Todo> getTodoListByDate(LocalDate date){
        return todoRepository.findByDueDate(date,TODO_SORT);
    }

    public List<Todo> getTodoListByRoom(Long roomId){
        return todoRepository.findByRoomId(roomId,TODO_SORT);
    }

    public List<Todo> getPreviousDateTodoList(LocalDate date){
        return getTodoListByDate(date.minusDays(1));
    }

    public List<Todo> getNextDateTodoList(LocalDate date){
        return getTodoListByDate(date.plusDays(1));
    }

    public Todo updateTodo(Long id, TodoRequestDto todoRequestDto){
        Todo todo = findTodo(id);
        applyTodoRequest(todo,todoRequestDto);
        return todoRepository.save(todo);
    }

    public Todo updateCompleted(Long id, boolean completed){
        Todo todo = findTodo(id);
        todo.setCompleted(completed);

        return todoRepository.save(todo);
    }

    public Todo completeTodo(Long id){
        return updateCompleted(id,true);
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

    public Todo findTodo(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Todo입니다."));
    }

    private void applyTodoRequest(Todo todo, TodoRequestDto requestDto){
        todo.setContent(requestDto.getContent());
        todo.setCompleted(requestDto.isCompleted());
        todo.setDueDate(requestDto.getDueDate());
        todo.setUserId(requestDto.getUserId());
        todo.setRoomId(requestDto.getRoomId());
    }

}
