package sping.api.spingboot.api.Category.entity;

import jakarta.persistence.*;
import lombok.*;
import sping.api.spingboot.helper.base.entity.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "category")
public class Category  extends BaseEntity{



    @Column(name = "cate_code", length = 20)
    private String cateCode;

    @Column(name = "cate_name", length = 50)
    private String cateName;
}
