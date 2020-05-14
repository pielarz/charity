package pl.pielarz.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pielarz.charity.model.Token;
import pl.pielarz.charity.model.User;
import pl.pielarz.charity.repository.TokenRepository;
import pl.pielarz.charity.repository.UserRepository;
import pl.pielarz.charity.service.UserService;

@Controller
public class EmailController {


    private UserService userService;
    private TokenRepository tokenRepository;
    private UserRepository userRepository;

    @Autowired
    public EmailController(UserService userService, TokenRepository tokenRepository, UserRepository userRepository) {
        this.userService = userService;
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/token")
    public String emailConfirmation(@RequestParam String value){
        Token token = tokenRepository.findByValue(value).get();
        User user = token.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        return "user/login";
    }


}
