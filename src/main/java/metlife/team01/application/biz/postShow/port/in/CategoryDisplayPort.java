package metlife.team01.application.biz.postShow.port.in;

import metlife.team01.application.adapter.in.controller.postShow.model.CategoryDisplayRequest;
import metlife.team01.application.adapter.in.controller.postShow.model.CategoryDisplayResponse;

import java.util.List;

public interface CategoryDisplayPort {

    public List<CategoryDisplayResponse> getCategoryByMenuLevel(CategoryDisplayRequest categoryDisplayRequest);
}
