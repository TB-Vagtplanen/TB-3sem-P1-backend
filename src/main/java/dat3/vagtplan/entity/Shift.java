package dat3.vagtplan.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime workHours;
    private String location;

    @ManyToOne
    @javax.validation.constraints.NotNull
    private User user;



    public Shift(LocalDate date, LocalTime workHours, String location) {
        this.date = date;
        this.workHours = workHours;
        this.location = location;

    }



}
