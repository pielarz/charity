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
import pl.pielarz.charity.repository.UserRepository;
import pl.pielarz.charity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "user/register";
    }
    @PostMapping("/register")
    public String registerUser(User user){
        userService.saveUser(user);
        return "home/index";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "user/login";
    }

    @PostMapping("/login")
    public String doLogin(@Valid @ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            return "user/login";
        }
        return "home/index";
    }


    @GetMapping("/user")
    public String userPage(Principal principal, Model model){
        model.addAttribute("userName", principal.getName());
        return "user/user_page";
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
