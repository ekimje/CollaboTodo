package CollaboTodo.Service;

import CollaboTodo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private final List<Todo> stort = new ArrayList<>();
    private Long seq = 1L;
    //생성
    public Todo createTodo(String title) {
        Todo todo = new Todo();
        todo.setId(seq++);
        todo.setTitle(title);
        todo.setDone(false);

        return todo;
    }
    //삭제
    public void deleteTodo(Long id){

    }

    //수정
    public void updateTodo(){}

    //완료
    public void toggleTodo(){}
}
