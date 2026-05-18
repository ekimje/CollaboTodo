package CollaboTodo.dto;

import CollaboTodo.Entity.Room;

import java.time.LocalDateTime;

public class RoomResponseDto {
    private Long roomId;
    private String roomName;
    private String inviteCode;
    private Long ownerUserId;
    private LocalDateTime createdAt;

    public RoomResponseDto(Room room){
        this.roomId = room.getRoomId();
        this.roomName = room.getRoomName();
        this.inviteCode = room.getInviteCode();
        this.ownerUserId = room.getOwnerUserId();
        this.createdAt = room.getCurrentAt();
    }

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

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
