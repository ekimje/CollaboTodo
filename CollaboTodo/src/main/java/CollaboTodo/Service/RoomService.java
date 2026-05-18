package CollaboTodo.Service;

import CollaboTodo.Entity.Room;
import CollaboTodo.Repository.RoomMemberRepository;
import CollaboTodo.Repository.RoomRepository;
import CollaboTodo.Repository.UserRepository;
import CollaboTodo.dto.RoomResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMemberRepository roomMemberRepository;
    private final UserRepository userRepository;

    public RoomService(RoomRepository roomRepository, RoomMemberRepository roomMemberRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.roomMemberRepository = roomMemberRepository;
        this.userRepository = userRepository;
    }

    public List<RoomResponseDto> getRooms(){
        return roomRepository.findAll().stream().map(RoomResponseDto::new).toList();
    }

    public RoomResponseDto getRoom(Long roomId){
        return new RoomResponseDto(findRoom(roomId));
    }
}
