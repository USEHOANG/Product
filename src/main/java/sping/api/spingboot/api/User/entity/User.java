package sping.api.spingboot.api.User.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import sping.api.spingboot.helper.base.entity.BaseEntity;

import javax.management.relation.Role;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Users")
public class User extends BaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    String username;

    @Size(min = 8, message = "Password tren 8 ky tu")
    String password;

    @Column(name = "firstName")
    String firstName;

    @Column(name = "lastName")
    String lastName;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    Set<String> roles; // Một user có thể có nhiều vai trò

    //hoang

}
