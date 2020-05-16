package pl.pielarz.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pielarz.charity.model.Token;
import pl.pielarz.charity.model.User;
import pl.pielarz.charity.repository.TokenRepository;
import pl.pielarz.charity.repository.UserRepository;

import javax.mail.MessagingException;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    private MailService mailService;
    private TokenRepository tokenRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(MailService mailService, TokenRepository tokenRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.mailService = mailService;
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        sendToken(user);
    }

    @Override
    public void sendToken(User user) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setUser(user);
        tokenRepository.save(token);

        String url = "http://localhost:8080/token?value=" + tokenValue;
        String subject = "Link aktywacyjny";
        String message = "Potwiedź rejestrację klikając w link w wiadomości :) \n\n" + url;

        try {
            mailService.sendMail(user.getEmail(), subject, message, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findByRoleLike("ROLE_USER");
    }

    @Override
    public List<User> findAllAdmins() {
        return userRepository.findByRoleLike("ROLE_ADMIN");
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void saveEditedUser(User user) {
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }
}
