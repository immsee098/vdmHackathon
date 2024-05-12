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
@Table(name="post_password", schema = "occyvdm")
public class PostPasswordEntity extends BaseTimeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pw_id")
    private long pwId;

    @Column(name = "post_id")
    private long postId;

    @Column(name = "post_password")
    private String postPassword;

    public PostPasswordEntity saveEntity(long postId, String postPassword) {
        this.postId = postId;
        this.postPassword = postPassword;
        return this;
    }
    public PostPasswordEntity(long pwId, long postId, String postPassword) {
        this.pwId = pwId;
        this.postId = postId;
        this.postPassword = postPassword;
    }
}
