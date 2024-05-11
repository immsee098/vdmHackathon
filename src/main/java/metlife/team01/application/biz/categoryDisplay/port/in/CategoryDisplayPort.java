package metlife.team01.application.biz.categoryDisplay.port.in;

import metlife.team01.application.adapter.in.controller.categoryDisplay.model.CategoryDisplayRequest;
import metlife.team01.application.adapter.in.controller.categoryDisplay.model.CategoryDisplayResponse;

import java.util.List;

public interface CategoryDisplayPort {

    public List<CategoryDisplayResponse> getCategoryByMenuLevel(CategoryDisplayRequest categoryDisplayRequest);
}
