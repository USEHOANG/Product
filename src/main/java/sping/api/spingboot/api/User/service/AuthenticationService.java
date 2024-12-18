package sping.api.spingboot.api.User.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sping.api.spingboot.api.User.model.request.AuthenticationRequest;
import sping.api.spingboot.api.User.repository.UserRepository;

@Service
//auto các biến
@RequiredArgsConstructor

// chúng ta mà không khai báo thì lombox sẽ tự động thành private
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

    // lấy thông tin của User
    UserRepository userRepository;

    public boolean authenticate(AuthenticationRequest request){
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return  passwordEncoder.matches(request.getPassword(), user.getPassword());
    }

}
