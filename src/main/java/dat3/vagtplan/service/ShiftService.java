package dat3.vagtplan.service;

import dat3.vagtplan.dto.ShiftRequest;
import dat3.vagtplan.dto.ShiftResponse;
import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.User;
import dat3.vagtplan.repository.ShiftRepository;
import dat3.vagtplan.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShiftService {
    static UserRepository userRepository;

    static ShiftRepository shiftRepository;

    public ShiftService(UserRepository userRepository, ShiftRepository shiftRepository) {
        this.userRepository = userRepository;
        this.shiftRepository = shiftRepository;
    }

    public ShiftResponse addShift(ShiftRequest body) {
        Shift shift = ShiftRequest.getShiftEntity(body);
        shift = shiftRepository.save(shift);

        return new ShiftResponse(shift);}

    @Transactional
    public ShiftResponse updateShift(ShiftRequest body) {
        Shift shift = shiftRepository.findById(body.getId()).orElseThrow(() ->
                new EntityNotFoundException("Shift could not be found"));
        User username = userRepository.findById(body.getUsername()).orElseThrow(() ->
                new  EntityNotFoundException("could not find user"));
        System.out.println(username);
        shiftRepository.updateUser(body.getId(),username);
        shift = shiftRepository.save(shift);
        return new ShiftResponse(shift);
    }

    public List<ShiftResponse> getAllShifts() {
        List<Shift> shifts = shiftRepository.findAll();
        List<ShiftResponse> shiftResponses = new ArrayList<>();
        shiftResponses = shifts.stream().map(shift -> new ShiftResponse(shift)).toList();
        return shiftResponses;

    }

    public ShiftResponse getSpecificShift(Long id) {
        Shift shift = shiftRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Could not find shift!"));
        return new ShiftResponse(shift);
    }

    public static ResponseEntity<Boolean> editShift(ShiftRequest body, Long id) {
        Shift editShift = shiftRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Could not find shift!"));
        if (body.getDate() != null){
            editShift.setDate(body.getDate());
        }
        if (body.getWorkHours() != null){
            editShift.setWorkHours(body.getWorkHours());
        }
        if (body.getLocation() != null){
            editShift.setLocation(body.getLocation());
        }
        if (body.getUsername() != null){
            editShift.setUsername(userRepository.findById(body.getUsername()).orElseThrow(() ->
                    new EntityNotFoundException()));
        }
        shiftRepository.save(editShift);

        return ResponseEntity.ok(true);
    }

    public void deleteShiftById(Long id) {
        shiftRepository.deleteById(id);
    }
   /* public ShiftResponse addShift(ShiftRequest body) {
        Shift shift = ShiftRequest.getShiftEntity(body);
        User user = userRepository.findById(body.getUser()).orElseThrow(() ->
                new  EntityNotFoundException("could not find user"));
        user.addShift(shift);
            shift = shiftRepository.save(shift);

        return new ShiftResponse(shift);

    }*/
}
