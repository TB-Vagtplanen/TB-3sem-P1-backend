package dat3.vagtplan.service;


import dat3.vagtplan.dto.UserRequest;
import dat3.vagtplan.dto.UserResponse;
import dat3.vagtplan.entity.User;
import dat3.vagtplan.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(UserResponse::new).toList();
    }


    public UserResponse addUser(UserRequest body) {
        User user = userRepository.save(UserRequest.getUserEntity(body));
        return new UserResponse(user);
    }

    public Boolean deleteUser(String username) {
        userRepository.deleteById(username);
        return true;
    }

    public Boolean flipEnabled(String username) {
        User user = userRepository.findById(username).orElseThrow(() -> new EntityNotFoundException("No such username found"));
        boolean value = !user.isEnabled();
        user.setEnabled(value);
        userRepository.save(user);
        return value;
    }

    public Boolean switchEnabled(String username, boolean value) {
        User user = userRepository.findById(username).orElseThrow(() -> new EntityNotFoundException("No such username found"));
        user.setEnabled(value);
        userRepository.save(user);
        return value;
    }

    public UserResponse findUser(String username) {
        return new UserResponse(userRepository.findByUsername(username));
    }

    public UserResponse editUser(UserRequest body) {
        //TODO
        return null;
    }
}
