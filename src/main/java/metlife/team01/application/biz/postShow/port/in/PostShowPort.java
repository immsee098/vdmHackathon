package metlife.team01.application.biz.postShow.port.in;

import metlife.team01.application.adapter.in.controller.postShow.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostShowPort {

    public Page<PostShowMasterResponse> getPostList(String ordrType, Pageable pageable);

    public long insertNewPost(PostShowDetailRequest request);

    public long updatePost(PostShowDetailRequest request);

}
