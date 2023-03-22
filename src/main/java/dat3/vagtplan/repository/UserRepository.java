package dat3.vagtplan.repository;

import dat3.vagtplan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {


    User findByUsername(String username);


}
