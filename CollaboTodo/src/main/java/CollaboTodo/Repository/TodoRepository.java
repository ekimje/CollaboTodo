package CollaboTodo.Repository;

import CollaboTodo.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

// DB 접근 계층. Data JPA를 사용하기 위해선 class가 아닌 interface로 만들고 JpaRepository 상속해야 함.
// 이러면 findAll() , save() 같은 메서드 자동 사용 가능.
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByDate(LocalDate dueDate);
}

