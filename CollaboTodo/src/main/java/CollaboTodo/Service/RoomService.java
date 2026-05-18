package CollaboTodo.Service;

import CollaboTodo.Entity.Room;
import CollaboTodo.Entity.RoomMember;
import CollaboTodo.Repository.RoomMemberRepository;
import CollaboTodo.Repository.RoomRepository;
import CollaboTodo.Repository.UserRepository;
import CollaboTodo.dto.RoomJoinRequestDto;
import CollaboTodo.dto.RoomRequestDto;
import CollaboTodo.dto.RoomResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    public RoomResponseDto createRoom(RoomRequestDto roomRequestDto){
        validateInviteCode(roomRequestDto.getRoomName());
        validateUser(roomRequestDto.getOwnerUserId());

        Room room = new Room();
        room.setRoomName(roomRequestDto.getRoomName());
        room.setOwnerUserId(roomRequestDto.getOwnerUserId());
        room.setInviteCode(roomRequestDto.getInviteCode());
        room.setCurrentAt(LocalDateTime.now());

        Room savedRoom = roomRepository.save(room);
        addRoomMember(savedRoom.getRoomId(), savedRoom.getOwnerUserId());

        return new RoomResponseDto(savedRoom);
    }

    public RoomResponseDto joinRoom(RoomJoinRequestDto roomJoinRequestDto){
        validateInviteCode(roomJoinRequestDto.getInviteCode());
        validateUser(roomJoinRequestDto.getUserId());

        Room room = roomRepository.findByInviteCode(roomJoinRequestDto.getInviteCode())
                .orElseThrow(()-> new IllegalArgumentException("초대 코드에 해당하는 방이 없습니다."));

        addRoomMember(room.getRoomId(), roomJoinRequestDto.getUserId());
        return new RoomResponseDto(room);
    }

    private Room findRoom(Long roomId){
        return roomRepository.findById(roomId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 방입니다."));
    }

    private  void validateInviteCode(String inviteCode){
        if(inviteCode == null || inviteCode.isBlank()){
            throw new IllegalArgumentException("초대 코드는 필수입니다.");
        }
    }

    private  void validateUser(Long userId){
        if(userId==null){throw new IllegalArgumentException("사용자 ID는 필수입니다.");}
        if(!userRepository.existsById(userId)){ throw new IllegalArgumentException("존재하지 않는 사용자입니다.");}
    }

    private String createUniqueInviteCode(String requestedInviteCode){
        if(requestedInviteCode != null && !requestedInviteCode.isBlank()){
           if(roomRepository.existsByInviteCode(requestedInviteCode)) {
               throw new IllegalArgumentException("이미 사용중인 초대 코드입니다.");
           }
           return requestedInviteCode;
        }
        String inviteCode;
        do{
            inviteCode = UUID.randomUUID().toString().substring(0,8);
        }while(roomRepository.existsByInviteCode(inviteCode));
        return inviteCode;
    }

    private void addRoomMember(Long roomId, Long userId){
        if(roomMemberRepository.existsByRoomIdAndUserId(roomId,userId)){
            return;
        }
        RoomMember roomMember = new RoomMember();
        roomMember.setRoomId(roomId);
        roomMember.setUserId(userId);
        roomMember.setCurrentAt(LocalDateTime.now());
        roomMemberRepository.save(roomMember);
    }
}
