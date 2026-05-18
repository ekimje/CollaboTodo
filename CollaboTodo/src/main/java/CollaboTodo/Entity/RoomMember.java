package CollaboTodo.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="room_members", uniqueConstraints = @UniqueConstraint(columnNames = {"room_id","user_id"}))
public class RoomMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_id",nullable = false)
    private Long roomId;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    private LocalDateTime currentAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCurrentAt() {
        return currentAt;
    }

    public void setCurrentAt(LocalDateTime currentAt) {
        this.currentAt = currentAt;
    }
}
