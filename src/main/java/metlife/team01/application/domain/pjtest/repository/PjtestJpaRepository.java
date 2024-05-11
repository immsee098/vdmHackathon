package metlife.team01.application.domain.pjtest.repository;

import metlife.team01.application.domain.pjtest.model.PjtestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PjtestJpaRepository extends JpaRepository<PjtestEntity, Long>, PjtestCustomRepository {
}
