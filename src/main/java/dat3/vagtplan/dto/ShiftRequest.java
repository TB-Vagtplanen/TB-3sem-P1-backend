package dat3.vagtplan.dto;

import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.Worker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ShiftRequest {
    Long id;
    LocalDate date;
    int workHours;

    //String worker;
    Worker worker;

    public static Shift getShiftEntity(ShiftRequest shiftRequest){
        return new Shift(shiftRequest.id, shiftRequest.getDate(), shiftRequest.getWorkHours());
    }
}
