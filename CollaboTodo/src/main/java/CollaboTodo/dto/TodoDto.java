package CollaboTodo.dto;

import java.time.LocalDateTime;

public class TodoDto {
    private String title;
    private LocalDateTime dueDate; // 마감일

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
