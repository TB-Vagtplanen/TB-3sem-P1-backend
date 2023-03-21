package dat3.vagtplan.repository;

import dat3.vagtplan.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,String> {
}
