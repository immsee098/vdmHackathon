package metlife.team01.application.domain.categoryDisplay.repository;

import metlife.team01.application.adapter.in.controller.categoryDisplay.model.CategoryDisplayResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDisplayCustomRepository {

    public List<CategoryDisplayResponse> findByLevelOrderByModifyAt(Integer menulvl);

    public List<CategoryDisplayResponse> findByParentCodeNumandLevel(Integer parentCodeNum, Integer menulvl);

    public List<CategoryDisplayResponse> findCategoryByCategoryName(String categoryName);
}
