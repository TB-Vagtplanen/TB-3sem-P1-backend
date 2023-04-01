package dat3.vagtplan.service;

import dat3.vagtplan.dto.ShiftRequest;
import dat3.vagtplan.dto.ShiftResponse;
import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.User;
import dat3.vagtplan.repository.ShiftRepository;
import dat3.vagtplan.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ShiftServiceTest {

    @Autowired
    ShiftRepository shiftRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    ShiftService shiftService;
    Boolean readyData = false;
    int listSize = 3;

    private User user;

    private Shift shift1;
    private Shift shift2;
    private Shift shift3;

    @BeforeEach
    void setUp(){
        if (!readyData) {
            //Creation of test data
            user = new User();
            user.setUsername("barboe");
            user.setEmail("TestMail");
            user.setPassword("HerpDerp");
            user.setFirstName("baron");
            user.setLastName("boef");
            user.setStreet("bobstreet");
            user.setZip("3000");
            user.setCity("city");
            user.setCreationDate((LocalDateTime.now()));
            user.setLastEdited((LocalDateTime.now()));
            user.addPhone("Test Phone", "21839421");
            user.setShifts(new ArrayList<Shift>());
            userRepository.save(user);

            shift1 = Shift.builder()
                    .workStart(LocalDateTime.of(2020,10,23,5,5,5))
                    .workEnd(LocalDateTime.of(2020,10,24,9,5,5))
                    .location("TestStreet")
                    .isSick(false)
                    .build();
            shift2 = Shift.builder()
                    .workStart(LocalDateTime.of(2020,11,23,5,5,5))
                    .workEnd(LocalDateTime.of(2020,11,24,9,5,5))
                    .location("TestStreet2")
                    .isSick(false)
                    .build();
            shift3 = Shift.builder()
                    .workStart(LocalDateTime.of(2020,12,23,5,5,5))
                    .workEnd(LocalDateTime.of(2020,12,24,9,5,5))
                    .location("TestStreet3")
                    .isSick(false)
                    .build();
            shiftRepository.save(shift1);
            shiftRepository.save(shift2);
            shiftRepository.save(shift3);
            readyData = true;
            shiftService = new ShiftService(userRepository,shiftRepository);
        }
        //console print checking the above "if" clause works
        for (ShiftResponse shiftResponse : shiftService.getAllShifts()) {
            System.out.println(shiftResponse.getId());
        }
    }

    @Test
    void addShift(){
        ShiftRequest shift =
                ShiftRequest.builder()
                .workStart(LocalDateTime.of(2020,11,23,5,5,5))
                .workEnd(LocalDateTime.of(2020,11,23,9,5,5))
                .location("TestStreet4")
                .username("barboe")
                .isSick(false)
                .build();

        ShiftResponse response = shiftService.addShift(shift);
        //since we never set "id" anywhere in the test code if the "assertTrue" is true
        //then id must be autogenerated
        assertTrue(response.getId() > 0);
        assertEquals(shift.getWorkStart(), response.getWorkStart());
        assertEquals(shift.getWorkEnd(), response.getWorkEnd());
        assertEquals(shift.getLocation(), response.getLocation());
        assertNotNull(response.getUser());
        assertEquals(shift.getIsSick(), response.getIsSick());
    }


    @Test
    void getAllShifts(){
        List<ShiftResponse> shifts = shiftService.getAllShifts();

        assertEquals(listSize, shifts.size());
    }

    @Test
    void getSpecificShift(){
        entityManager.createNativeQuery("ALTER TABLE shift ALTER COLUMN id RESTART WITH 1").executeUpdate();

        Shift shift = Shift.builder()
                .workStart(LocalDateTime.of(2020,10,23,5,5,5))
                .workEnd(LocalDateTime.of(2020,10,24,9,5,5))
                .location("TestStreet")
                .isSick(false)
                .build();
        shiftRepository.save(shift);
        ShiftResponse getShift = shiftService.getSpecificShift(1);

       //the setup generates 3 shifts
        // so if correctly generated ids 1-3 should be available to be found
        // i chose shift2 so if i use the getSpecificShift method to get id = 2
        // it should be equal to shift2
        assertEquals(shift.getId() , getShift.getId());
        assertEquals(shift.getWorkStart() , getShift.getWorkStart());
        assertEquals(shift.getWorkEnd() , getShift.getWorkEnd());
        assertEquals(shift.getLocation() , getShift.getLocation());
        assertEquals(shift.getIsSick() , getShift.getIsSick());
    }

    @Test
    void editShift(){
        ShiftRequest expected = ShiftRequest.builder()
                .workStart(LocalDateTime.of(2025,10,23,10,5,5))
                .workEnd(LocalDateTime.of(2025,10,24,15,5,5))
                .location("EditedLocal")
                .isSick(true)
                .build();

        shiftService.editShift(expected, shift1.getId());

        assertEquals(shift1.getWorkStart(), expected.getWorkStart());
        assertEquals(shift1.getWorkEnd(), expected.getWorkEnd());
        assertEquals(shift1.getLocation(), expected.getLocation());
        assertEquals(shift1.getIsSick(), expected.getIsSick());

    }

    @Test
    void deleteShiftById(){
        //confirm exsistance of object to be deleted
        System.out.println(shift1.getId() + " delete test");
        //deleting the object
        shiftService.deleteShiftById(shift1.getId());

        //Confirm object no longer exsists
        assertFalse(shiftRepository.existsById(shift1.getId()));
    }

}