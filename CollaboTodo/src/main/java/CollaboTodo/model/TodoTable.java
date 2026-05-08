package CollaboTodo.model;

import java.time.LocalDateTime;
import java.util.Date;

public class TodoTable {
    private Long id;
    private String content;
    private boolean completed;
    private Date due_date;
    private Long user_id;
    private Long Roomid;
    private LocalDateTime current_t;
}
