package dat3.vagtplan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShiftResponse {
    Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime workStart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime workEnd;

    String location;

    User username;


    public ShiftResponse(Shift shift){
        this.id = shift.getId();
        this.workStart = shift.getWorkStart();
        this.workEnd = shift.getWorkEnd();
        this.location = shift.getLocation();
        this.username = shift.getUsername();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShiftResponse that = (ShiftResponse) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(workStart, that.workStart) &&
                Objects.equals(workEnd, that.workEnd) &&
                Objects.equals(location, that.location) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workStart, workEnd, location, username);
    }
}
