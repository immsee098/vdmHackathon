package metlife.team01.application.domain.postShow.repository;

import metlife.team01.application.domain.postShow.model.PostLikeViewEntity;
import metlife.team01.application.domain.postShow.model.PostPasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeViewJpaRepository extends JpaRepository<PostLikeViewEntity, Long>, PostLikeViewCustomRepository {
    PostLikeViewEntity findByPostId(long postId);
}
