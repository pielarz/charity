package pl.pielarz.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.pielarz.charity.model.Category;
import pl.pielarz.charity.model.Donation;
import pl.pielarz.charity.model.Institution;
import pl.pielarz.charity.model.User;
import pl.pielarz.charity.repository.UserRepository;
import pl.pielarz.charity.service.CategoryServiceImpl;
import pl.pielarz.charity.service.DonationServiceImpl;
import pl.pielarz.charity.service.InstitutionServiceImpl;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class DonationController {

    @Autowired
    DonationServiceImpl donationService;
    @Autowired
    InstitutionServiceImpl institutionService;
    @Autowired
    CategoryServiceImpl categoryService;


    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return institutionService.findAll();
    }
    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/donation/add")
    public String showDonationForm(Model model){
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        return "form/donation_form";
    }
    @PostMapping("/donation/add")
    public String getDonationForm(Donation donation){
        donationService.save(donation);
        return "form/donation_form-confirmation";
    }

}
