package CollaboTodo.Repository;

import CollaboTodo.Entity.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomMemberRepository extends JpaRepository<RoomMember, Long> {
    List<RoomMember> findByRoomId(Long roomId);
    List<RoomMember> findByUserId(Long userId);

    Optional<RoomMember> findByRoomIdAndUserId(Long roomId, Long userId);

    boolean exitsByRoomIdAndUserId(Long roomId, Long userId);
}
