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

    public PostShowDetailResponse(PostDetailShowEntity detailShowEntity) {
        this.postDetailId = detailShowEntity.getPostDetailId();
        this.postId = detailShowEntity.getPostId();
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.crtdDate = crtdDate;
        this.dltYn = dltYn;
        this.view = view;
        this.like = like;
    }
}
