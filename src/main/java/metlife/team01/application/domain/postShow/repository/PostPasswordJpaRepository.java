package metlife.team01.application.domain.postShow.repository;

import metlife.team01.application.domain.postShow.model.PostMasterShowEntity;
import metlife.team01.application.domain.postShow.model.PostPasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostPasswordJpaRepository extends JpaRepository<PostPasswordEntity, Long> {
}
