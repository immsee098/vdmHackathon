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
@Table(name="post_content_d", schema = "occyvdm")
public class PostDetailShowEntity extends BaseTimeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_detail_id")
    private long postDetailId;

    @Column(name = "post_id")
    private long postId;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "dlt_yn")
    private String dltYn;

    public PostDetailShowEntity saveEntity(long postId, String postContent, String dltYn) {
        this.postId = postId;
        this.postContent = postContent;
        this.dltYn = dltYn;

        return this;
    }

    public PostDetailShowEntity(long postDetailId, long postId, String postContent,  String dltYn) {
        this.postDetailId = postDetailId;
        this.postId = postId;
        this.postContent = postContent;
        this.dltYn = dltYn;
    }
}
