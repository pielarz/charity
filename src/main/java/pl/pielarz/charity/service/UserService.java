package pl.pielarz.charity.service;

import org.springframework.stereotype.Service;
import pl.pielarz.charity.model.User;

import java.util.Optional;

@Service
public interface UserService {
    void saveUser(User user);
    void sendToken(User user);
}
