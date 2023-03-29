package dat3.vagtplan.configuration;


import dat3.security.entity.Role;
import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.User;
import dat3.vagtplan.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class DeveloperData implements ApplicationRunner {

    //repositories
    UserRepository userRepository;

    public DeveloperData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user = User.builder()

                .firstName("Mark")
                .lastName("Denner")
                .city("Copenhagen")
                .zip("2100")
                .street("Somestreet")
                .build();

        User user2 = User.builder()

                .firstName("Kristian")
                .lastName("Wede")
                .city("someplace")
                .zip("somezip")
                .street("Somestreet")
                .build();

        user.addRole(Role.USER);
        user.setUsername("MarDyrDen");
        user.setEmail("somemail@email.com");
        user.setPassword("pubad555");

        user.addPhone("mobile", "12345678");


        System.out.println(user);
        user2.addRole(Role.ADMIN);
        user2.setUsername("Kræl");
        user2.setEmail("someotheremail@email.com");
        user2.setPassword("viggo123");

        //Dummy data with shifts.

        Shift shift1 = Shift.builder()
                .date(LocalDate.parse("2023-03-22"))
                .workHours(LocalTime.parse("08:00:00"))
                .location("På gulvet")
                .isSick(false)
                .build();


        Shift shift2 = Shift.builder()
                .date(LocalDate.parse("2023-03-23"))
                .workHours(LocalTime.parse("08:00:00"))
                .location("I kassen")
                .isSick(false)
                .build();


        Shift shift3 = Shift.builder()
                .date(LocalDate.parse("2023-03-24"))
                .workHours(LocalTime.parse("08:00:00"))
                .location("På gulvet")
                .isSick(false)
                .build();


        user.addShift(shift1);
        user.addShift(shift2);
        user2.addShift(shift3);

        userRepository.save(user);
        userRepository.save(user2);

    }
}
