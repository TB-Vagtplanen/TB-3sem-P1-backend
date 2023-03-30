package dat3.vagtplan.dto;

import dat3.security.entity.Role;
import dat3.vagtplan.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    String firstName;
    String lastName;
    String street;
    String zip;
    String city;
    String email;
    String username;
    String password;
    Map<String, String> phones = new HashMap<>();
    Role role;


    public static User getUserEntity(UserRequest body) {
        User user = User.builder()
            .street(body.street)
            .zip(body.zip)
            .city(body.city)
            .firstName(body.firstName)
            .lastName(body.lastName)
            .build();
        user.setPassword(body.getPassword());
        user.setUsername(body.getUsername());
        user.setPhones(body.getPhones());
        user.setEmail(body.getEmail());

        if (body.role != null) {
            user.addRole(body.getRole());
        }
        System.out.println(body);
        return user;

    }



}
