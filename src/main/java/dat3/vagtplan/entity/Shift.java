package dat3.vagtplan.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

import java.time.LocalDateTime;
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
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime workStart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime workEnd;
    private String location;

    private Boolean isSick;

    @ManyToOne
    private User user;



    public Shift(LocalDateTime date, LocalDateTime workHours, String location, Boolean isSick) {
        this.workStart = date;
        this.workEnd = workHours;
        this.location = location;
        this.isSick = isSick;

    }



}
