package dat3.vagtplan.configuration;


import dat3.security.entity.Role;
import dat3.vagtplan.entity.Shift;
import dat3.vagtplan.entity.User;
import dat3.vagtplan.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

        User user1 = User.builder()
            .firstName("Alice")
            .lastName("Johnson")
            .city("New York")
            .zip("10001")
            .street("Broadway")
            .build();
        user1.addRole(Role.ADMIN);
        user1.setUsername("AliJoh");
        user1.setEmail("alice.johnson@example.com");
        user1.setPassword("mypassword");
        user1.addPhone("mobile", "123456789");

        User user2 = User.builder()
            .firstName("Bob")
            .lastName("Smith")
            .city("San Francisco")
            .zip("94102")
            .street("Market Street")
            .build();
        user2.addRole(Role.USER);
        user2.setUsername("BobSmi");
        user2.setEmail("bob.smith@example.com");
        user2.setPassword("mypassword");
        user2.addPhone("mobile", "234567890");

        User user3 = User.builder()
            .firstName("Cathy")
            .lastName("Jones")
            .city("Chicago")
            .zip("60601")
            .street("Michigan Avenue")
            .build();
        user3.addRole(Role.USER);
        user3.setUsername("CatJon");
        user3.setEmail("cathy.jones@example.com");
        user3.setPassword("mypassword");
        user3.addPhone("mobile", "345678901");

        User user4 = User.builder()
            .firstName("David")
            .lastName("Miller")
            .city("Seattle")
            .zip("98101")
            .street("Pike Place")
            .build();
        user4.addRole(Role.USER);
        user4.setUsername("DavMil");
        user4.setEmail("david.miller@example.com");
        user4.setPassword("mypassword");
        user4.addPhone("mobile", "456789012");

        User user5 = User.builder()
            .firstName("Emily")
            .lastName("Davis")
            .city("Los Angeles")
            .zip("90001")
            .street("Hollywood Boulevard")
            .build();
        user5.addRole(Role.USER);
        user5.setUsername("EmiDav");
        user5.setEmail("emily.davis@example.com");
        user5.setPassword("mypassword");
        user5.addPhone("mobile", "567890123");

        User user6 = User.builder()
            .firstName("Frank")
            .lastName("Brown")
            .city("Houston")
            .zip("77002")
            .street("Main Street")
            .build();
        user6.addRole(Role.USER);
        user6.setUsername("FraBro");
        user6.setEmail("frank.brown@example.com");
        user6.setPassword("mypassword");
        user6.addPhone("mobile", "678901234");

        User user7 = User.builder()
            .firstName("Gabrielle")
            .lastName("Wilson")
            .city("Philadelphia")
            .zip("19102")
            .street("Chestnut Street")
            .build();
        user7.addRole(Role.USER);
        user7.setUsername("GabWil");
        user7.setEmail("gabrielle.wilson@example.com");
        user7.setPassword("mypassword");
        user7.addPhone("mobile", "789012345");

        User user8 = User.builder()
            .firstName("Isabella")
            .lastName("Clark")
            .city("Austin")
            .zip("78701")
            .street("Congress Avenue")
            .build();
        user8.addRole(Role.USER);
        user8.setUsername("IsaCla");
        user8.setEmail("isabella.clark@example.com");
        user8.setPassword("mypassword");
        user8.addPhone("mobile", "890123456");

        User user9 = User.builder()
            .firstName("Jacob")
            .lastName("Martin")
            .city("Denver")
            .zip("80202")
            .street("16th Street")
            .build();
        user9.addRole(Role.USER);
        user9.setUsername("JacMar");
        user9.setEmail("jacob.martin@example.com");
        user9.setPassword("mypassword");
        user9.addPhone("mobile", "901234567");

        User user10 = User.builder()
            .firstName("Katherine")
            .lastName("Garcia")
            .city("Boston")
            .zip("02108")
            .street("Beacon Street")
            .build();
        user10.addRole(Role.USER);
        user10.setUsername("KatGar");
        user10.setEmail("katherine.garcia@example.com");
        user10.setPassword("mypassword");
        user10.addPhone("mobile", "012345678");

        User user11 = User.builder()
            .firstName("Liam")
            .lastName("Wilson")
            .city("Portland")
            .zip("97204")
            .street("Burnside Street")
            .build();
        user11.addRole(Role.USER);
        user11.setUsername("LiaWil");
        user11.setEmail("liam.wilson@example.com");
        user11.setPassword("mypassword");
        user11.addPhone("mobile", "123456789");

        User user12 = User.builder()
            .firstName("Mia")
            .lastName("Rodriguez")
            .city("San Diego")
            .zip("92101")
            .street("Gaslamp Quarter")
            .build();
        user12.addRole(Role.USER);
        user12.setUsername("MiaRod");
        user12.setEmail("mia.rodriguez@example.com");
        user12.setPassword("mypassword");
        user12.addPhone("mobile", "234567890");

        User user13 = User.builder()
            .firstName("Noah")
            .lastName("Anderson")
            .city("Dallas")
            .zip("75201")
            .street("Main Street")
            .build();
        user13.addRole(Role.USER);
        user13.setUsername("NoaAnd");
        user13.setEmail("noah.anderson@example.com");
        user13.setPassword("mypassword");
        user13.addPhone("mobile", "345678901");

        User user14 = User.builder()
            .firstName("Olivia")
            .lastName("Martinez")
            .city("Atlanta")
            .zip("30303")
            .street("Peachtree Street")
            .build();
        user14.addRole(Role.USER);
        user14.setUsername("OliMar");
        user14.setEmail("olivia.martinez@example.com");
        user14.setPassword("mypassword");
        user14.addPhone("mobile", "456789012");

        User user15 = User.builder()
            .firstName("Peter")
            .lastName("Hernandez")
            .city("Phoenix")
            .zip("85004")
            .street("Roosevelt Row")
            .build();
        user15.addRole(Role.USER);
        user15.setUsername("PetHer");
        user15.setEmail("peter.hernandez@example.com");
        user15.setPassword("mypassword");
        user15.addPhone("mobile", "567890123");

        User user16 = User.builder()
            .firstName("Quinn")
            .lastName("Young")
            .city("Seattle")
            .zip("98101")
            .street("Pike Street")
            .build();
        user16.addRole(Role.USER);
        user16.setUsername("QuiYou");
        user16.setEmail("quinn.young@example.com");
        user16.setPassword("mypassword");
        user16.addPhone("mobile", "678901234");

        User user17 = User.builder()
            .firstName("Riley")
            .lastName("King")
            .city("New Orleans")
            .zip("70112")
            .street("Canal Street")
            .build();
        user17.addRole(Role.USER);
        user17.setUsername("RilKin");
        user17.setEmail("riley.king@example.com");
        user17.setPassword("mypassword");
        user17.addPhone("mobile", "789012345");

        User user18 = User.builder()
            .firstName("Samantha")
            .lastName("Wright")
            .city("San Francisco")
            .zip("94102")
            .street("Haight Street")
            .build();
        user18.addRole(Role.USER);
        user18.setUsername("SamWri");
        user18.setEmail("samantha.wright@example.com");
        user18.setPassword("mypassword");
        user18.addPhone("mobile", "890123456");

        User user19 = User.builder()
            .firstName("Thomas")
            .lastName("Adams")
            .city("Houston")
            .zip("77002")
            .street("Main Street")
            .build();
        user19.addRole(Role.USER);
        user19.setUsername("ThoAda");
        user19.setEmail("thomas.adams@example.com");
        user19.setPassword("mypassword");
        user19.addPhone("mobile", "901234567");

        User user20 = User.builder()
            .firstName("Uma")
            .lastName("Patel")
            .city("Chicago")
            .zip("60601")
            .street("Michigan Avenue")
            .build();
        user20.addRole(Role.USER);
        user20.setUsername("UmaPat");
        user20.setEmail("uma.patel@example.com");
        user20.setPassword("mypassword");
        user20.addPhone("mobile", "012345678");

        User user21 = User.builder()
            .firstName("Victoria")
            .lastName("Lee")
            .city("Los Angeles")
            .zip("90015")
            .street("Santee Alley")
            .build();
        user21.addRole(Role.USER);
        user21.setUsername("VicLee");
        user21.setEmail("victoria.lee@example.com");
        user21.setPassword("mypassword");
        user21.addPhone("mobile", "123456789");



        //Dummy data with shifts.

        Shift shift1 = Shift.builder()
                .workStart(LocalDateTime.parse("2023-03-22T08:00:00"))
                .workEnd(LocalDateTime.parse("2023-03-22T12:00:00"))
                .location("På gulvet")
                .isSick(false)
                .build();


        Shift shift2 = Shift.builder()
                .workStart(LocalDateTime.parse("2023-03-23T08:00:00"))
                .workEnd(LocalDateTime.parse("2023-03-23T12:00:00"))
                .location("På gulvet")
                .isSick(false)
                .build();


        Shift shift3 = Shift.builder()
                .workStart(LocalDateTime.parse("2023-05-22T08:00:00"))
                .workEnd(LocalDateTime.parse("2023-05-22T12:00:00"))
                .location("I kassen")
                .isSick(true)
                .build();


        user1.addShift(shift1);
        user1.addShift(shift2);
        user2.addShift(shift3);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        userRepository.save(user8);
        userRepository.save(user9);
        userRepository.save(user10);
        userRepository.save(user11);
        userRepository.save(user12);
        userRepository.save(user13);
        userRepository.save(user14);
        userRepository.save(user15);
        userRepository.save(user16);
        userRepository.save(user17);
        userRepository.save(user18);
        userRepository.save(user19);
        userRepository.save(user20);
        userRepository.save(user21);


    }
}
