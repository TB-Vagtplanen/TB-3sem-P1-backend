package dat3.vagtplan.repository;

import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<Shift,Integer> {
    @Modifying
    @Query("update Shift s SET s.user = :value where s.id = :id")
    void updateUser(@Param("id") int id, @Param("value") User user);

}
