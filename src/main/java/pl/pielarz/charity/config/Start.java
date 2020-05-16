package pl.pielarz.charity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.pielarz.charity.model.Category;
import pl.pielarz.charity.model.Donation;
import pl.pielarz.charity.model.Institution;
import pl.pielarz.charity.model.User;
import pl.pielarz.charity.repository.CategoryRepository;
import pl.pielarz.charity.repository.DonationRepository;
import pl.pielarz.charity.repository.InstitutionRepository;
import pl.pielarz.charity.repository.UserRepository;


/*
THIS CLASS IS ONLY FOR TESTING
 */
@Configuration
public class Start {

    public Start(UserRepository userRepository, PasswordEncoder passwordEncoder,
                 CategoryRepository categoryRepository,
                 InstitutionRepository institutionRepository) {

        //--------USERS---------

        //ADMIN
        User admin = new User();
        admin.setUsername("admin123");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setName("admin");
        admin.setLastName("adminar");
        admin.setEmail("admin@admin.pl");
        admin.setRole("ROLE_ADMIN");
        admin.setEnabled(true);


        //USER
        User user = new User();
        user.setUsername("user123");
        user.setPassword(passwordEncoder.encode("user123"));
        user.setName("user");
        user.setLastName("userer");
        user.setEmail("user@user.pl");
        user.setRole("ROLE_USER");
        user.setEnabled(true);

        //ANONYMOUS USER
        User anonymous = new User();
        anonymous.setUsername("anonymous");
        anonymous.setPassword(passwordEncoder.encode("anonymous"));
        anonymous.setName("Gal");
        anonymous.setLastName("Anonim");
        anonymous.setEmail("anonim@anonim.pl");
        anonymous.setRole("ROLE_USER");
        anonymous.setEnabled(true);

        //SAVE USERS
        userRepository.save(admin);
        userRepository.save(user);
        userRepository.save(anonymous);



        //---------CATEGORIES----------
        Category toys = new Category();
        Category clothes = new Category();
        Category books = new Category();
        Category other = new Category();

        other.setName("Inne");
        books.setName("Książki");
        clothes.setName("Ubrania");
        toys.setName("Zabawki");

        //SAVE CATEGORIES
        categoryRepository.save(other);
        categoryRepository.save(books);
        categoryRepository.save(clothes);
        categoryRepository.save(toys);


        //---------INSTITUTIONS---------
        Institution institution1 = new Institution();
        Institution institution2 = new Institution();
        Institution institution3 = new Institution();
        Institution institution4 = new Institution();

        institution1.setName("Pomoc Biednym");
        institution1.setDescription("Pomagamy biednym");
        institution2.setName("Pomoc Ubogim");
        institution2.setDescription("Pomagamy ubogim");
        institution3.setName("Pomoc dzieciom");
        institution3.setDescription("Pomagamy dzieciom");
        institution4.setName("Pomoc niepełnosprawnym");
        institution4.setDescription("Pomagamy niepełnosprawnym");

        //SAVE INSTITUTIONS
        institutionRepository.save(institution1);
        institutionRepository.save(institution2);
        institutionRepository.save(institution3);
        institutionRepository.save(institution4);


    }



}
