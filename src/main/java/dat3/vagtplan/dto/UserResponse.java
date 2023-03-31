package dat3.vagtplan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {


    private String username;
    private String firstName;
    private String lastName;

    private String email;
    private String street;
    private String zip;
    private String city;
    private LocalDateTime created;
    private LocalDateTime lastEdited;

    private Map<String,String> phones = new HashMap<>();

    private List<Shift> shifts = new ArrayList<>();



    public UserResponse(User user) {
        this.city = user.getCity();
        this.street = user.getStreet();
        this.zip = user.getZip();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phones = user.getPhones();
        this.shifts = user.getShifts();

    }

}
