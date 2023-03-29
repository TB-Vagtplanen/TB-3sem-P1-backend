package dat3.vagtplan.api;


import dat3.vagtplan.dto.UserRequest;
import dat3.vagtplan.dto.UserResponse;
import dat3.vagtplan.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserResponse addUser(@RequestBody UserRequest userRequest) {
        return userService.addUser(userRequest);
    }

    @GetMapping("/{username}")
    UserResponse findUser(@PathVariable String username) {
        return userService.findUser(username);
    }

    @PutMapping()
    UserResponse editUser(@RequestBody UserRequest body) {
        return userService.editUser(body);
    }


    @DeleteMapping("/{username}")
    Boolean deleteUser(@PathVariable String username) {
        return userService.deleteUser(username);
    }


    @PatchMapping("/enabled/{username}")
    Boolean flipEnabled(@PathVariable String username) {
        return userService.flipEnabled(username);
    }

    @PatchMapping("/enabled/{username}/{value}")
    Boolean switchEnabled(@PathVariable String username, @PathVariable boolean value) {
        return userService.switchEnabled(username,value);
    }






}
