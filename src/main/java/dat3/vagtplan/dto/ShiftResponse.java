package dat3.vagtplan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShiftResponse {
    Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
    @JsonFormat(pattern = "HH:mm:ss")
    LocalTime workHours;

    String location;
    User user;

    Boolean isSick;

    public ShiftResponse(Shift shift){
        this.id = shift.getId();
        this.date = shift.getDate();
        this.workHours = shift.getWorkHours();
        this.location = shift.getLocation();
        this.user = shift.getUser();
        this.isSick = shift.getIsSick();
    }
}
