package dat3.vagtplan.dto;

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
public class WorkerRequest {
    String userName;
    String lastName;
    double pay;

    /* public Worker getWorkerEntity(WorkerRequest workerRequest){
        return new Worker(workerRequest.userName, workerRequest.getLastName(), workerRequest.getPay()
                );
    }*/

    public static Worker getWorkerEntity(WorkerRequest workerRequest){
        return new Worker(workerRequest.userName, workerRequest.getLastName(), workerRequest.getPay());
    }
}
