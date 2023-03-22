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

    public UserResponse getUserByID(String username) {
        User user = userRepository.findById(username).orElseThrow(() ->
                new EntityNotFoundException("User not found!"));
        return new UserResponse(user);
    }
}
