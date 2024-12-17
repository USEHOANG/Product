package sping.api.spingboot.api.SubCategory.entity;

import jakarta.persistence.*;
import lombok.*;
import sping.api.spingboot.api.Category.entity.Category;
import sping.api.spingboot.helper.base.entity.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sub_category")
public class SubCategory  extends BaseEntity{



    @Column(name = "sub_cate_code", length = 20)
    private String subCateCode;

    @Column(name = "sub_cate_name", length = 50)
    private String subCateName;

    @ManyToOne
    @JoinColumn(name = "cate_id", nullable = false)
    private Category category;


}
