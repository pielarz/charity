package pl.pielarz.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pielarz.charity.model.Institution;
import pl.pielarz.charity.service.DonationServiceImpl;
import pl.pielarz.charity.service.InstitutionServiceImpl;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    InstitutionServiceImpl institutionService;
    @Autowired
    DonationServiceImpl donationService;

    @RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
    public String homeAction() {
        return "home/index";
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }

    @ModelAttribute("totalBags")
    public Integer totalBags() {
        return donationService.totalQuantityOfBags();
    }

    @ModelAttribute("totalDonations")
    public Integer totalDonations() {
        return donationService.findAll().size();
    }

}
