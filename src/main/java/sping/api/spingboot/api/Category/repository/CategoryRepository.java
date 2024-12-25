package sping.api.spingboot.api.Category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sping.api.spingboot.api.Category.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {

    @Query(value = """
SELECT * FROM category WHERE LOWER(cate_name) LIKE LOWER(CONCAT('%', :keyword, '%'))
""", nativeQuery = true)
    List<Category> Search(@Param("keyword") String keyword);

    boolean existsByCateName(String cateName);
}
