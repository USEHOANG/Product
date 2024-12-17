package sping.api.spingboot.api.Brand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sping.api.spingboot.api.Brand.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
