package dat3.vagtplan.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime workStart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime workEnd;
    private String location;

    @JsonBackReference
    @ManyToOne
    @javax.validation.constraints.NotNull
    private User username;



    public Shift(LocalDateTime workStart, LocalDateTime workEnd, String location) {
        this.workStart = workStart;
        this.workEnd = workEnd;
        this.location = location;

    }



}
