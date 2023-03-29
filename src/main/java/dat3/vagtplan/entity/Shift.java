package dat3.vagtplan.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
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

    private Boolean isSick;

    @ManyToOne
    private User user;



    public Shift(LocalDate date, LocalTime workHours, String location, Boolean isSick) {
        this.date = date;
        this.workHours = workHours;
        this.location = location;
        this.isSick = isSick;

    }



}
