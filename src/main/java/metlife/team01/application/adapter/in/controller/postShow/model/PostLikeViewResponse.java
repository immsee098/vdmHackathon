package metlife.team01.application.adapter.in.controller.postShow.model;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import metlife.team01.application.domain.postShow.model.PostDetailShowEntity;
import metlife.team01.application.domain.postShow.model.PostLikeViewEntity;
import metlife.team01.application.domain.postShow.model.PostMasterShowEntity;

import java.io.Serial;
import java.io.Serializable;

@Getter
@NoArgsConstructor
public class PostLikeViewResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long vlId;

    private long postId;

    private int likeCount;

    private int viewCount;

    @QueryProjection
    public PostLikeViewResponse(PostLikeViewEntity likeViewEntity) {
        this.vlId = likeViewEntity.getVlId();
        this.postId = likeViewEntity.getPostId();
        this.likeCount = likeViewEntity.getLikeCount();
        this.viewCount = likeViewEntity.getViewCount();
    }

}

