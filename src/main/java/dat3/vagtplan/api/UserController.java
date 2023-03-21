package dat3.vagtplan.api;


import dat3.vagtplan.dto.UserResponse;
import dat3.vagtplan.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping
    List<UserResponse> getUsers() {
        return userService.getUsers();
    }



}
