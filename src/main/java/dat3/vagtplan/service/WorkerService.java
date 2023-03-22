package dat3.vagtplan.service;

import dat3.vagtplan.dto.WorkerRequest;
import dat3.vagtplan.dto.WorkerResponse;
import dat3.vagtplan.entity.Worker;
import dat3.vagtplan.repository.WorkerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    static WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository){
        WorkerService.workerRepository = workerRepository;
    }

    public WorkerResponse getWorkerByID(String username) {
       Worker worker = workerRepository.findById(username).orElseThrow(() ->
        new EntityNotFoundException("Worker not found!"));
        return new WorkerResponse(worker);
    }

    public WorkerResponse addWorker(WorkerRequest body) {
        Worker worker = WorkerRequest.getWorkerEntity(body);
        worker = workerRepository.save(worker);
        return new WorkerResponse(worker);
    }
}
