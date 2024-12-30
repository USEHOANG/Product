package sping.api.spingboot.api.User.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sping.api.spingboot.api.User.model.request.AuthenticationRequest;
import sping.api.spingboot.api.User.model.respones.AuthenticationResponse;
import sping.api.spingboot.api.User.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean isAuthenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());

        String role = user.getRoles().stream()
                .map(Enum::name)  // Đảm bảo tên vai trò có tiền tố "ROLE_"
                .findFirst()
                .orElse(null);

        return AuthenticationResponse.builder()
                .authenticated(isAuthenticated)
                .role(role)
                .build();
    }
}
