package metlife.team01.application.biz.categoryDisplay.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.categoryDisplay.model.CategoryDisplayRequest;
import metlife.team01.application.adapter.in.controller.categoryDisplay.model.CategoryDisplayResponse;
import metlife.team01.application.biz.categoryDisplay.port.in.CategoryDisplayPort;
import metlife.team01.application.domain.categoryDisplay.repository.CategoryDisplayJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryDisplayService implements CategoryDisplayPort {

    private final CategoryDisplayJpaRepository categoryDisplayJpaRepository;


    @Transactional
    @Override
    public List<CategoryDisplayResponse> getCategoryByMenuLevel(CategoryDisplayRequest categoryDisplayRequest) {
        return categoryDisplayJpaRepository.findByLevelOrderByModifyAt(categoryDisplayRequest.getMenuLevel());
    }
}
