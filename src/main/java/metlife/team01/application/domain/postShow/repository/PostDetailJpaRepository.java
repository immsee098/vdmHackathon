package metlife.team01.application.domain.postShow.repository;

import metlife.team01.application.domain.postShow.model.PostDetailShowEntity;
import metlife.team01.application.domain.postShow.model.PostMasterShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDetailJpaRepository extends JpaRepository<PostDetailShowEntity, Long>, PostDetailCustomRepository {
}
