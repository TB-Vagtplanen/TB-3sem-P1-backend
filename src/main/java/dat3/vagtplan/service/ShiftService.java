package dat3.vagtplan.service;

import dat3.vagtplan.dto.ShiftRequest;
import dat3.vagtplan.dto.ShiftResponse;
import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.repository.ShiftRepository;
import org.springframework.stereotype.Service;

@Service
public class ShiftService {

    static ShiftRepository shiftRepository;

    public ShiftService(ShiftRepository shiftRepository){
        ShiftService.shiftRepository = shiftRepository;
    }

    public ShiftResponse addShift(ShiftRequest body) {
        Shift shift = ShiftRequest.getShiftEntity(body);
        shift = shiftRepository.save(shift);
        return new ShiftResponse(shift);

    }
}
