package kr.ac.mjc.kiosk.repository;

import kr.ac.mjc.kiosk.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryCode(String categoryCode);

    List<Category> findAll();

    Optional<Category> findBy(Long id);

    Optional<Category> findBy(String name);

}
