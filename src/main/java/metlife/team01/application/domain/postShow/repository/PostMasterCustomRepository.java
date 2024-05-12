package metlife.team01.application.domain.postShow.repository;

import metlife.team01.application.adapter.in.controller.postShow.model.CategoryDisplayResponse;
import metlife.team01.application.adapter.in.controller.postShow.model.PostShowMasterRequest;
import metlife.team01.application.adapter.in.controller.postShow.model.PostShowMasterResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMasterCustomRepository {

    public List<CategoryDisplayResponse> findByLevelOrderByModifyAt(Integer menulvl);

    public List<CategoryDisplayResponse> findByParentCodeNumandLevel(Integer parentCodeNum, Integer menulvl);

    public List<CategoryDisplayResponse> findCategoryByCategoryName(String categoryName);

    public Page<PostShowMasterResponse> getPostListMaster(PostShowMasterRequest request, Pageable pageable);
}
