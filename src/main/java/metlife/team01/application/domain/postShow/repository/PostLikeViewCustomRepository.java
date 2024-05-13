package metlife.team01.application.domain.postShow.repository;

import metlife.team01.application.adapter.in.controller.postShow.model.PostLikeViewResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeViewCustomRepository {
    public PostLikeViewResponse getPostLikeViewInfo(long postId);
}
