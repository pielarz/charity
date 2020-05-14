package pl.pielarz.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.pielarz.charity.model.Institution;
import pl.pielarz.charity.service.InstitutionService;
import pl.pielarz.charity.service.InstitutionServiceImpl;

import javax.naming.Binding;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String adminView(Principal principal, Model model) {
        model.addAttribute("admin", principal.getName());
        return "admin/admin";
    }

    @GetMapping("/foundations")
    public String foundations() {
        return "admin/foundations";
    }

    @GetMapping("/foundations/form")
    public String createOrEditInstitution(@RequestParam(required = false) Long id, Model model) {
        Institution institution = id == null ? new Institution() : institutionService.findById(id);
        model.addAttribute("institution", institution);
        return "admin/add_institution";
    }
    @PostMapping("/foundations/form")
    public String postInstitution(@Valid Institution institution, BindingResult result){
        if(result.hasErrors()){
            return "admin/add_institution";
        }
        institutionService.save(institution);
        return "admin/admin";
    }

    @GetMapping("/foundations/delete")
    public String deleteFoundation(@RequestParam Long id){
        institutionService.deleteById(id);
        return "admin/admin";
    }

    @Autowired
    InstitutionService institutionService;

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }

}
