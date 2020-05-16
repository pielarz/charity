package pl.pielarz.charity.service;

import org.springframework.stereotype.Service;
import pl.pielarz.charity.model.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    void saveUser(User user);
    void sendToken(User user);
    List<User> findAllUsers();
    List<User> findAllAdmins();
    User findById(Long id);
    void deleteById(Long id);
    void saveEditedUser(User user);
    void saveEditedRoleUser(User user);
    User findByUsername(String username);

}
