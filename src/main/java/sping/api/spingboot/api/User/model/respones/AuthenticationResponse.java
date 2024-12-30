package sping.api.spingboot.api.User.model.respones;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor // Tạo constructor có tham số
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
     boolean authenticated;
     String role;
}
