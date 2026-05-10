package CollaboTodo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String content;
    private boolean completed;
    private LocalDate due_date; // 마감일
    private Long user_id;
    private Long roomId;
    private LocalDate current_t; // 등록일

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRoomid() {
        return roomId;
    }

    public void setRoomid(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getCurrent_t() {
        return current_t;
    }

    public void setCurrent_t(LocalDate current_t) {
        this.current_t = LocalDate.now();
    }
}
