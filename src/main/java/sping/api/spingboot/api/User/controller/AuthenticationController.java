package sping.api.spingboot.api.User.controller;


import io.swagger.v3.oas.models.responses.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sping.api.spingboot.api.User.model.request.AuthenticationRequest;
import sping.api.spingboot.api.User.model.respones.AuthenticationResponse;
import sping.api.spingboot.api.User.service.AuthenticationService;

@RestController
@RequestMapping("/auth")

//auto các biến
@RequiredArgsConstructor

// chúng ta mà không khai báo thì lombox sẽ tự động thành private
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        boolean result = authenticationService.authenticate(request);
        return ResponseEntity.ok(AuthenticationResponse.builder()
                .authenticated(result)
                .build());
    }

}
