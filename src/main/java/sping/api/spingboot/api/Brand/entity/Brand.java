package sping.api.spingboot.api.Brand.entity;

import jakarta.persistence.*;
import lombok.*;
import sping.api.spingboot.helper.base.entity.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "brand")
public class Brand  extends BaseEntity {

    @Column(name = "brand_name", length = 50)
    private String brandName;
}
