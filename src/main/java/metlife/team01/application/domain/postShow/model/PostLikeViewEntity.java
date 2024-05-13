package metlife.team01.application.domain.postShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import metlife.team01.config.jpa.BaseTimeEntity;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name="post_view_like", schema = "occyvdm")
public class PostLikeViewEntity extends BaseTimeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vl_id")
    private long vlId;

    @Column(name = "post_id")
    private long postId;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "view_count")
    private int viewCount;

    public PostLikeViewEntity(long vlId, long postId, int likeCount, int viewCount) {
        this.vlId = vlId;
        this.postId = postId;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
    }

    public PostLikeViewEntity saveEntity(long postId, int likeCount, int viewCount) {
        this.postId = postId;
        this.likeCount = likeCount;
        this.viewCount = viewCount;

        return this;
    }

}
