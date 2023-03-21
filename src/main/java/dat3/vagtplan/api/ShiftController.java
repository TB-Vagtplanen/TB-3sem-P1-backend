package dat3.vagtplan.api;

import dat3.vagtplan.dto.ShiftRequest;
import dat3.vagtplan.dto.ShiftResponse;
import dat3.vagtplan.service.ShiftService;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/shifts")
public class ShiftController {

    ShiftService shiftService;

    public ShiftController(ShiftService shiftService){
        this.shiftService = shiftService;
    }

    @PostMapping
    ShiftResponse addShift(@RequestBody ShiftRequest body){
        return shiftService.addShift(body);
    }
}
