package pl.pielarz.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.pielarz.charity.model.User;
import pl.pielarz.charity.service.UserService;
import javax.validation.Valid;
import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String userPage(Principal principal, Model model){
        String name = principal.getName();
        model.addAttribute("user", name);
        User user = userService.findByUsername(name);
        model.addAttribute("currentUserId", user.getId());
        return "user/user_page";
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
        userService.saveUser(user);
        if(user.getRole().equals("ROLE_ADMIN")){
            return "redirect:/admin/admin_list";
        }
        return "user/user_page";
    }


    @Autowired
    UserService userService;



}
