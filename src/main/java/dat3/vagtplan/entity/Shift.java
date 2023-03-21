package dat3.vagtplan.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter

@Entity
public class Shift {


    @Id
    private Integer id;
    private LocalTime duration;
    private String location;
    private LocalDate date;
    private LocalTime startsAt;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private User user;






}
