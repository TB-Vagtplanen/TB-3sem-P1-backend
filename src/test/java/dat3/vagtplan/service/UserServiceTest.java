package dat3.vagtplan.service;

import dat3.security.entity.Role;
import dat3.vagtplan.dto.ShiftRequest;
import dat3.vagtplan.dto.ShiftResponse;
import dat3.vagtplan.dto.UserRequest;
import dat3.vagtplan.dto.UserResponse;
import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.User;
import dat3.vagtplan.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    UserService userService;

    Boolean readyData = false;
    int listSize = 3;
    int activeList = 2;

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp(){
        if (!readyData) {
            //Creation of test data
            user1 = new User();
            user1.setUsername("barboe");
            user1.setEmail("TestMail");
            user1.setPassword("HerpDerp");
            user1.setFirstName("baron");
            user1.setLastName("boef");
            user1.setStreet("bobstreet");
            user1.setZip("3000");
            user1.setCity("city");
            user1.setCreationDate((LocalDateTime.now()));
            user1.setLastEdited((LocalDateTime.now()));
            user1.addPhone("Test Phone", "21839421");
            user1.setShifts(new ArrayList<Shift>());
            userRepository.save(user1);

            user2 = User.builder()
                    .firstName("Tester2")
                    .lastName("Test2")
                    .street("street2")
                    .zip("2000")
                    .city("city2")
                    .creationDate((LocalDateTime.now()))
                    .lastEdited((LocalDateTime.now()))
                    .phones(new HashMap<>())
                    .shifts(new ArrayList<>())
                    .build();
            user2.setUsername("tessec");
            user2.setEmail("Email2");
            user2.setPassword("test2");
            userRepository.save(user2);

            user3 = User.builder()
                    .firstName("Tester3")
                    .lastName("Test3")
                    .street("street3")
                    .zip("1000")
                    .city("city3")
                    .creationDate((LocalDateTime.now()))
                    .lastEdited((LocalDateTime.now()))
                    .phones(new HashMap<>())
                    .shifts(new ArrayList<>())
                    .build();

            user3.setUsername("testhi");
            user3.setEmail("Email3");
            user3.setPassword("test3");
            user3.setEnabled(false);
            userRepository.save(user3);


            readyData = true;
            userService = new UserService(userRepository);
        }
        //console print checking the above "if" clause works
        for (UserResponse userResponse : userService.getUsers()) {
            System.out.println(userResponse.getUsername());
        }
    }



    @Test
    void getUsers(){
        List<UserResponse> users = userService.getUsers();

        assertEquals(listSize, users.size());
    }
    @Test
    void addUser(){
        UserRequest newUser = new UserRequest();

        newUser.setFirstName("New");
        newUser.setLastName("Guy");
        newUser.setStreet("newStreet");
        newUser.setZip("5000");
        newUser.setCity("newCity");
        newUser.setUsername("NewGuy");
        newUser.setEmail("newEmail");
        newUser.setPassword("NewPas");
        newUser.setPhones(new HashMap<>());
        newUser.setRole(Role.USER);

        UserResponse response = userService.addUser(newUser);

        assertEquals(newUser.getFirstName(), response.getFirstName());
        assertEquals(newUser.getLastName(), response.getLastName());
        assertEquals(newUser.getStreet(), response.getStreet());
        assertEquals(newUser.getZip(), response.getZip());
        assertEquals(newUser.getCity(), response.getCity());
        assertEquals(newUser.getUsername(), response.getUsername());
        assertEquals(newUser.getPhones(), response.getPhones());

    }
    @Test
    void deleteUser(){
        //confirm exsistance of object to be deleted
        System.out.println(user1.getUsername() + " delete test");
        //deleting the object
        userService.deleteUser(user1.getUsername());

        //Confirm object no longer exsists
        assertFalse(userRepository.existsById(user1.getUsername()));
    }
    @Test
    void flipEnabled(){
        //show if flip is not enabled
        user1.setEnabled(false);
        //save boolean change to DB
        userRepository.save(user1);
        System.out.println(user1.isEnabled()+ " false");

        boolean value =  userService.flipEnabled(user1.getUsername());
        System.out.println(value+ " true");

        assertTrue(value);
    }
    @Test
    void editUser(){

        UserRequest expected = new UserRequest();
        expected.setFirstName("New");
        expected.setLastName("Guy");
        expected.setStreet("newStr");
        expected.setZip("5000");
        expected.setCity("newCity");
        //selecting the exsisting user
        expected.setUsername(user1.getUsername());
        expected.setEmail("newEmail");
        expected.setPassword("NewPas");
        expected.setPhones(new HashMap<>());
        expected.setRole(Role.USER);

       UserResponse response = userService.editUser(expected);
        assertEquals(expected.getFirstName(), response.getFirstName());
        assertEquals(expected.getLastName(), response.getLastName());
        assertEquals(expected.getEmail(), response.getEmail());
        assertEquals(expected.getCity(), response.getCity());
        assertEquals(expected.getStreet(), response.getStreet());
        assertEquals(expected.getZip(), response.getZip());



    }
    @Test
    void getActiveUsers(){
        List<UserResponse> activeUsers = userService.getActiveUsers();

        assertEquals(activeList, activeUsers.size());

    }
}
