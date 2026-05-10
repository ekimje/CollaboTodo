package CollaboTodo.Entity;

import java.time.LocalDateTime;

public class Room {
    private Long roomId;
    private String roomName;
    private String invite_code;
    private LocalDateTime current_at;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }

    public LocalDateTime getCurrent_at() {
        return current_at;
    }

    public void setCurrent_at(LocalDateTime current_at) {
        this.current_at = current_at;
    }
}
