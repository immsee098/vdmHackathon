package metlife.team01.application.adapter.in.controller.postShow.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import metlife.team01.application.domain.postShow.model.PostDetailShowEntity;
import metlife.team01.application.domain.postShow.model.PostMasterShowEntity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostShowDetailResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    private long postDetailId;

    private long postId;

    private String postTitle;

    private String postContent;

    private LocalDateTime crtdDate;

    private String dltYn;

    private int view;
    private int like;

    @QueryProjection
    public PostShowDetailResponse(PostDetailShowEntity detailShowEntity, PostMasterShowEntity entity) {
        this.postDetailId = detailShowEntity.getPostDetailId();
        this.postId = detailShowEntity.getPostId();
        this.postTitle = entity.getPostTitle();
        this.postContent = detailShowEntity.getPostContent();
        this.dltYn = entity.getDltYn();
        this.crtdDate = entity.getCrtdDate();
    }

    public PostShowDetailResponse setCounts(PostShowDetailResponse response, int view, int like) {
        this.postDetailId = response.getPostDetailId();
        this.postId = response.getPostId();
        this.postTitle = response.getPostTitle();
        this.postContent = response.getPostContent();
        this.dltYn = response.getDltYn();
        this.crtdDate = response.getCrtdDate();
        this.view = view;
        this.like = like;

        return this;
    }
}
