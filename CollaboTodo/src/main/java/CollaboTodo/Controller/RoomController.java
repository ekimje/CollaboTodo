package CollaboTodo.Controller;

import CollaboTodo.Entity.Todo;
import CollaboTodo.Service.RoomService;
import CollaboTodo.Service.TodoService;
import CollaboTodo.dto.RoomJoinRequestDto;
import CollaboTodo.dto.RoomRequestDto;
import CollaboTodo.dto.RoomResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    private final TodoService todoService;

    public RoomController(RoomService roomService, TodoService todoService){
        this.roomService = roomService;
        this.todoService = todoService;
    }

    @GetMapping
    public List<RoomResponseDto> getRooms(){
        return roomService.getRooms();
    }

    @GetMapping("/{roomId}")
    public RoomResponseDto getRoom(@PathVariable Long roomId){
        return roomService.getRoom(roomId);
    }

    @GetMapping("/{roomId}/todos")
    public List<Todo> getRoomTodos(@PathVariable Long roomId){
        roomService.getRoom(roomId);
        return todoService.getTodoListByRoom(roomId);
    }

    @PostMapping
    public RoomResponseDto createRoom(@RequestBody RoomRequestDto roomRequestDto){
        return roomService.createRoom(roomRequestDto);
    }

    @PostMapping("/join")
    public RoomResponseDto joinRoom(@RequestBody RoomJoinRequestDto roomJoinRequestDto){
        return roomService.joinRoom(roomJoinRequestDto);
    }
}
