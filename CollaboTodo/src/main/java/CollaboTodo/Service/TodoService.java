package CollaboTodo.Service;

import CollaboTodo.Entity.Todo;
import CollaboTodo.Repository.TodoRepository;
import CollaboTodo.dto.TodoRequestDto;

public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public static Todo createTodo(TodoRequestDto requestDto){
        Todo todo = new Todo();

        todo.setContent(requestDto.getContent());
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

}
