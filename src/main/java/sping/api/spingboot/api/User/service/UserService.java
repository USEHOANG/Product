package sping.api.spingboot.api.User.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sping.api.spingboot.api.User.entity.User;
import sping.api.spingboot.api.User.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByid(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not null"));
    }

    public int addUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username đã tồn tại");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user).getId();
    }

    public int updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User không tồn tại"));

        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());

        return userRepository.save(existingUser).getId();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
