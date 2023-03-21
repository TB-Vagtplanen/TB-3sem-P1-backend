package dat3.vagtplan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.vagtplan.entity.Shift;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShiftResponse {
    Long id;
    LocalDate date;
    int workHours;

    public ShiftResponse(Shift shift){
        this.id = shift.getId();
        this.date = shift.getDate();
        this.workHours = shift.getWorkHours();
    }
}
