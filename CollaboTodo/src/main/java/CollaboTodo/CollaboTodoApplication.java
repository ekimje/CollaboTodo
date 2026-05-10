package CollaboTodo;

import CollaboTodo.Entity.Todo;
import CollaboTodo.Repository.TodoRepository;
import CollaboTodo.UI.TodoCalendar;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class CollaboTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaboTodoApplication.class, args);
	}

	@Bean
	CommandLineRunner todo(TodoRepository todoRepository) {
        return args -> {
            Todo todo = new Todo();
            TodoCalendar cal = new TodoCalendar();
            cal.printCalendar();

            todo.setContent("스프링공부");

            Todo savedTodo = todoRepository.save(todo);

            System.out.println(savedTodo.getId());

            savedTodo.setCompleted(true);
            todoRepository.save(savedTodo);

            todoRepository.delete(savedTodo);
            System.out.println("삭제 완료");
        };
    }


}
