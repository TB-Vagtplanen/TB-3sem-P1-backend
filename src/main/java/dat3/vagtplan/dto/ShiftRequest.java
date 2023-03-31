package dat3.vagtplan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.vagtplan.entity.Shift;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ShiftRequest {

    int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime workStart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime workEnd;
    String location;
    @NotNull
    String username;
    Boolean isSick;

    public static Shift getShiftEntity(ShiftRequest shiftRequest){
        return new Shift(shiftRequest.getWorkStart(), shiftRequest.getWorkEnd(),
                shiftRequest.getLocation(), shiftRequest.getIsSick());
    }
}
