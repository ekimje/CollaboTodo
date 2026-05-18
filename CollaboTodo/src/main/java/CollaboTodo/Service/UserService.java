package CollaboTodo.Service;

import CollaboTodo.Entity.User;
import CollaboTodo.Repository.UserRepository;
import CollaboTodo.dto.UserRequestDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public User createUser(UserRequestDto userRequestDto){
        if(userRepository.existsByEmail(userRequestDto.getEmail())){
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
        User user = new User();
        user.setEmail(userRequestDto.getEmail());
        user.setName(userRequestDto.getName());
        user.setCurrentAt(LocalDateTime.now());
        return userRepository.save(user);
    }
}
