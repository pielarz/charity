package pl.pielarz.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.pielarz.charity.model.Institution;
import pl.pielarz.charity.model.User;
import pl.pielarz.charity.service.InstitutionService;
import pl.pielarz.charity.service.UserService;

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
    public String postInstitution(@Valid Institution institution, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/add_institution";
        }
        institutionService.save(institution);
        return "redirect:/admin/foundations";
    }

    @GetMapping("/foundations/delete")
    public String deleteFoundation(@RequestParam Long id) {
        institutionService.deleteById(id);
        return "redirect:/admin/foundations";
    }

    //----------------USERS-----------------
    @GetMapping("/users")
    public String users() {
        return "admin/user_list";
    }

    @GetMapping("/admins")
    public String admins(){
        return "admin/admin_list";
    }

    @GetMapping("/users/form")
    public String getEditUser(@RequestParam Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "admin/edit_user";
    }

    @PostMapping("/users/form")
    public String postEditUser(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/edit_user";
        }
        user.setEnabled(true);
        userService.saveEditedUser(user);
        if(user.getRole().equals("ROLE_ADMIN")){
            return "redirect:/admin/admin_list";
        }
        return "admin/user_list";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam Long id){
        userService.deleteById(id);
        return "admin/user_list";
    }

    @GetMapping("/users/block")
    public String blockUser(@RequestParam Long id){
        User user = userService.findById(id);
        if(user.isEnabled()){
            user.setEnabled(false);
        } else {
            user.setEnabled(true);
        }
        userService.saveEditedUser(user);
        return "admin/user_list";
    }

    @GetMapping("/users/changeRole")
    public String changeRoleOfUser(@RequestParam Long id){
        User user = userService.findById(id);
        if(user.getRole().equals("ROLE_USER")){
            user.setRole("ROLE_ADMIN");
        } else {
            user.setRole("ROLE_USER");
        }
        userService.saveEditedRoleUser(user);
        return "redirect:/admin/users";
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
    public List<User> adminList() {
        return userService.findAllAdmins();
    }

}
