package dat3.vagtplan.service;

import dat3.vagtplan.dto.ShiftRequest;
import dat3.vagtplan.dto.ShiftResponse;
import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.User;
import dat3.vagtplan.repository.ShiftRepository;
import dat3.vagtplan.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ShiftService {
    UserRepository userRepository;

    ShiftRepository shiftRepository;

    public ShiftService(UserRepository userRepository, ShiftRepository shiftRepository) {
        this.userRepository = userRepository;
        this.shiftRepository = shiftRepository;
    }

    public ShiftResponse addShift(ShiftRequest body) {
        Shift shift = ShiftRequest.getShiftEntity(body);
        User user = userRepository.findById(body.getUser()).orElseThrow(() ->
                new  EntityNotFoundException("could not find user"));
        user.addShift(shift);
        shift = shiftRepository.save(shift);
        return new ShiftResponse(shift);

    }
}
