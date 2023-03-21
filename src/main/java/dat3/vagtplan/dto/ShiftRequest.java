package dat3.vagtplan.dto;

import dat3.vagtplan.entity.Shift;
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
    Date date;
    int workHours;

    public static Shift getShiftEntity(ShiftRequest shiftRequest){
        return new Shift(shiftRequest.id, shiftRequest.getDate(), shiftRequest.getWorkHours());
    }
}
