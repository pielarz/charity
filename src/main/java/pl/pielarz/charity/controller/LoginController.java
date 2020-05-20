package pl.pielarz.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pielarz.charity.model.User;
import pl.pielarz.charity.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "security/register";
    }
    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "security/register";
        }
        userService.saveUser(user);
        return "home/index";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "security/login";
    }

    @PostMapping("/login")
    public String doLogin(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "security/login";
        }
        return "home/index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login";
    }

}
