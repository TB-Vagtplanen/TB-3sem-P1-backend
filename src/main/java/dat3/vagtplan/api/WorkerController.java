package dat3.vagtplan.api;

import dat3.vagtplan.dto.WorkerRequest;
import dat3.vagtplan.dto.WorkerResponse;
import dat3.vagtplan.service.WorkerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/workers")
public class WorkerController {

    WorkerService workerService;

    public WorkerController(WorkerService workerService){
        this.workerService = workerService; }

    @GetMapping(path = "/{username}")
    WorkerResponse getWorkerByID(@PathVariable String username){
        return workerService.getWorkerByID(username);
    }

    @PostMapping
    WorkerResponse addWorker(@RequestBody WorkerRequest body){
        return workerService.addWorker(body);
    }
}
