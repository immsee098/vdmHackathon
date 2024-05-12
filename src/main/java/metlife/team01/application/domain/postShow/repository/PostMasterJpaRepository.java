package metlife.team01.application.domain.postShow.repository;

import metlife.team01.application.domain.postShow.model.CategoryDisplayEntity;
import metlife.team01.application.domain.postShow.model.PostMasterShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMasterJpaRepository extends JpaRepository<PostMasterShowEntity, Long>, PostMasterCustomRepository {
}
