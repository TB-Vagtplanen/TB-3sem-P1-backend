package dat3.vagtplan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Shift {
    @Id
    private Long id;
    private LocalDate date;
    private int workHours;
    private List<Worker> workers;
}
