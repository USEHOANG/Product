package sping.api.spingboot.api.User.model.respones;

import lombok.*;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {

    //dặt 1 biến authenticated ( nếu biến này true thì user cung cấp username và password đúng
    // nếu fall thì thì user cung cấp username và password sai
    boolean authenticated;
}
