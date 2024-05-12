package metlife.team01.application.adapter.in.controller.postShow.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import metlife.team01.application.domain.postShow.model.PostLikeViewEntity;
import metlife.team01.application.domain.postShow.model.PostMasterShowEntity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostShowMasterResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    private long postId;

    private String postTitle;

    private LocalDateTime crtdDate;

    private String dltYn;

    private int view;
    private int like;

    @QueryProjection
    public PostShowMasterResponse(PostMasterShowEntity entity, int viewCount, int likeCount) {
        this.postId = entity.getPostId();
        this.postTitle = entity.getPostTitle();
        this.crtdDate = entity.getCrtdDate();
        this.dltYn = entity.getDltYn();
        this.view = viewCount;
        this.like = likeCount;
    }

}
