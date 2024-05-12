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
@Table(name="post_content_m", schema = "occyvdm")
public class PostMasterShowEntity extends BaseTimeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long postId;

    @Column(name = "post_title")
    private String postTitle;


    @Column(name = "dlt_yn")
    private String dltYn;

    public PostMasterShowEntity saveEntity(String postTitle, String dltYn) {
        this.postTitle = postTitle;
        this.dltYn = dltYn;
        return this;
    }

    public PostMasterShowEntity(long postId, String postTitle, String dltYn) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.dltYn = dltYn;
    }

}
