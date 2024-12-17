package sping.api.spingboot.api.SubCategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sping.api.spingboot.api.SubCategory.entity.SubCategory;
@Repository
public interface SubcategoryRepository extends JpaRepository<SubCategory, Long> {
}
