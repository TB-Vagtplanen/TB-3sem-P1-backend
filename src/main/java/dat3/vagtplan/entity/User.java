package dat3.vagtplan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dat3.security.entity.UserWithRoles;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
@Entity
public class User extends UserWithRoles {

    private String firstName;
    private String lastName;
    private String street;
    private String zip;
    private String city;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private LocalDateTime creationDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @UpdateTimestamp
    private LocalDateTime lastEdited;

    @ElementCollection
    @MapKeyColumn(name = "Description")
    @Column(name = "phoneNumber")
    private Map<String,String> phones = new HashMap<>();


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "user")
    List<Shift> shifts = new ArrayList<>();

    public void addPhone(String description, String phonenumber) {
        if (phones == null) {
            phones = new HashMap<>();
        }
        phones.put(description,phonenumber);
    }

    public void addShift(Shift shift){
        if (shifts == null){
            shifts = new ArrayList<>();
        }
        shifts.add(shift);
        shift.setUser(this);
    }


}
