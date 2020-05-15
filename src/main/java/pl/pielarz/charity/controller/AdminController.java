package pl.pielarz.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.pielarz.charity.model.Institution;
import pl.pielarz.charity.model.User;
import pl.pielarz.charity.service.InstitutionService;
import pl.pielarz.charity.service.InstitutionServiceImpl;
import pl.pielarz.charity.service.UserService;

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

    //-------------FOUNDATIONS-------------
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
        return "redirect:/admin/foundations";
    }

    @GetMapping("/foundations/delete")
    public String deleteFoundation(@RequestParam Long id){
        institutionService.deleteById(id);
        return "redirect:/admin/foundations";
    }

    //----------------USERS-----------------
    @GetMapping("/users")
    public String users(){
        return "admin/users";
        }





    @Autowired
    InstitutionService institutionService;

    @Autowired
    UserService userService;

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }

    @ModelAttribute("users")
    public List<User> userList() {
        return userService.findAllUsers();
    }

    @ModelAttribute("admins")
    public List<User> adminList(){
        return userService.findAllAdmins();
    }

}
