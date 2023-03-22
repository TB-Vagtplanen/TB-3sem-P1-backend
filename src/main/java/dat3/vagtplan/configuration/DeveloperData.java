package dat3.vagtplan.configuration;


import dat3.security.entity.Role;
import dat3.vagtplan.entity.User;
import dat3.vagtplan.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

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

        user.addPhone("mobile","12345678");


        System.out.println(user);
        user2.addRole(Role.USER);
        user2.setUsername("Kræl");
        user2.setEmail("someotheremail@email.com");
        user2.setPassword("viggo123");

        userRepository.save(user);
        userRepository.save(user2);



    }
}
