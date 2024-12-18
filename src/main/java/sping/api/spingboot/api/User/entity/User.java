package sping.api.spingboot.api.User.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import sping.api.spingboot.helper.base.entity.BaseEntity;

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

    //hoang

}
