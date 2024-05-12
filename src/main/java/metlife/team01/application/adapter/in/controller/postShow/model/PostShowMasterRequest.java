package metlife.team01.application.adapter.in.controller.postShow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class PostShowMasterRequest {

    private long postId;

    private String postTitle;

    private String crtdDate;

    private String dltYn;

    private String ordrBy;
}
