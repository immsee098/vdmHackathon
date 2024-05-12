package metlife.team01.application.domain.postShow.repository;

import metlife.team01.application.domain.postShow.model.CategoryDisplayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDisplayJpaRepository extends JpaRepository<CategoryDisplayEntity, Long>, CategoryDisplayCustomRepository {
}
