package metlife.team01.application.domain.postShow.repository;

import metlife.team01.application.adapter.in.controller.postShow.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostDetailCustomRepository {

    public PostShowDetailResponse getPostDetailInfo(PostShowDetailRequest request);

}
