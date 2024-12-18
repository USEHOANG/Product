package sping.api.spingboot.api.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sping.api.spingboot.api.User.entity.User;
import sping.api.spingboot.api.User.enums.Role;
import sping.api.spingboot.api.User.repository.UserRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByid(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not null"));
    }

    public int addUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException("Username đã tồn tại ");
        }

        //mã hóa mật khẩu
        // tạo BCryptPasswordEncoder chuyền độ mạnh củ password ( thông số cang lớn thì độ giải càng khó )
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // phân quyền
        HashSet<String> roles = new HashSet<>();
        roles.add(Role.ROLE_EMPLOYEE.name());
        user.setRoles(roles);

        return userRepository.save(user).getId();
    }

    public int updateUser(Long id, User user) {
       return userRepository.save(user).getId();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
