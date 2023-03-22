package dat3.vagtplan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.vagtplan.entity.Shift;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ShiftRequest {
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
    @JsonFormat(pattern = "HH:mm:ss")
    LocalTime workHours;

    String location;

    String user;

    public static Shift getShiftEntity(ShiftRequest shiftRequest){
        return new Shift(shiftRequest.getDate(), shiftRequest.getWorkHours(),
                shiftRequest.getLocation());
    }
}
