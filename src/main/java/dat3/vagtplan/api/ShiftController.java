package dat3.vagtplan.api;

import dat3.vagtplan.dto.ShiftRequest;
import dat3.vagtplan.dto.ShiftResponse;
import dat3.vagtplan.service.ShiftService;
import org.apache.coyote.Request;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/shifts")
public class ShiftController {

    ShiftService shiftService;

    public ShiftController(ShiftService shiftService){
        this.shiftService = shiftService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/makeShift"  )
    public ShiftResponse addShift(@RequestBody ShiftRequest body){
        return shiftService.addShift(body);
    }
    @PostMapping("/addUserToShift")
    public ShiftResponse updateShift(@RequestBody ShiftRequest body){
        return shiftService.updateShift(body);
    }
}
