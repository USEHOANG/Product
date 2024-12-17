package sping.api.spingboot.api.Status.entity;

import jakarta.persistence.*;
import lombok.*;
import sping.api.spingboot.helper.base.entity.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "status")
public class Status  extends BaseEntity{

    @Column(name = "status_name", length = 100)
    private String statusName;
}
