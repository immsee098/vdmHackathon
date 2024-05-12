package metlife.team01.application.adapter.in.controller.postShow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class PostShowDetailRequest {

    private long postDetailId;

    private long postId;

    private String postTitle;
    private String postContent;

    private LocalDateTime crtdDate;

    private String dltYn;

    private String password;

    private int view;
    private int like;
}
