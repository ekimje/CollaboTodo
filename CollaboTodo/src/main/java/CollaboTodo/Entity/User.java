package CollaboTodo.Entity;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String email;
    private String password;
    private LocalDateTime current_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCurrent_at() {
        return current_at;
    }

    public void setCurrent_at(LocalDateTime current_at) {
        this.current_at = current_at;
    }
}
