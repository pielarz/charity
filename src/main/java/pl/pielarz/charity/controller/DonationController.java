package pl.pielarz.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pielarz.charity.model.Category;
import pl.pielarz.charity.model.Donation;
import pl.pielarz.charity.model.Institution;
import pl.pielarz.charity.model.User;
import pl.pielarz.charity.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    DonationServiceImpl donationService;
    @Autowired
    InstitutionServiceImpl institutionService;
    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationFacade authentication;


    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @ModelAttribute("user")
    public User currentUser() {
        String username = authentication.getAuthentication().getName();
        User user = userService.findByUsername(username);
        return user;
    }

    @GetMapping("/add")
    public String showDonationForm(Model model) {
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        return "form/donation_form";
    }

    @PostMapping("/add")
    public String getDonationForm(@Valid Donation donation, @ModelAttribute("user")User user) {
        if(authentication.getAuthentication().isAuthenticated()){
            List<Donation> userDonations = user.getDonations();
            userDonations.add(donation);
            donation.setUser(user);
            userService.saveEditedUser(user);
        }
        donationService.save(donation);

        return "form/donation_form-confirmation";
    }


}
