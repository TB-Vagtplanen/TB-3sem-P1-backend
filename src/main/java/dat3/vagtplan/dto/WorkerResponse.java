package dat3.vagtplan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.Worker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkerResponse {
    String userName;
    String lastName;
    double pay;

    public WorkerResponse(Worker worker){
        this.userName = worker.getUserName();
        this.lastName = worker.getLastName();
        this.pay = worker.getPay();
    }

}
