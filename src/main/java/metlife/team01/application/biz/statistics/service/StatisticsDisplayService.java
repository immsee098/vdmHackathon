package metlife.team01.application.biz.statistics.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import metlife.team01.application.adapter.in.controller.statistics.model.AllStatisticsResponse;
import metlife.team01.application.adapter.in.controller.statistics.model.StatisticResponse;
import metlife.team01.application.biz.statistics.port.in.StatisticsDisplayPort;
import metlife.team01.application.domain.postShow.repository.CategoryDisplayJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticsDisplayService implements StatisticsDisplayPort {

    private final CategoryDisplayJpaRepository categoryDisplayJpaRepository;

    @Transactional
    @Override
    public List<AllStatisticsResponse> getAllStatistics() {

        val parent_list =  categoryDisplayJpaRepository.findByLevelOrderByModifyAt(1);
        val response = parent_list.stream().map(parent -> {
            val child_list = categoryDisplayJpaRepository.findByParentCodeNumandLevel(parent.getCodeNum(), 2).stream().toList();
            Map<String, Long> itemCount = child_list.stream().collect(Collectors.groupingBy(e -> e.getCodeName(), Collectors.counting()));
            List<StatisticResponse> childs = new ArrayList<>();
            for(String key: itemCount.keySet()){
                childs.add(new StatisticResponse(key, itemCount.get(key)));
            }
            return new AllStatisticsResponse(parent.getCodeNum(),parent.getCodeName(),child_list.size(), childs);
        }).toList();
        return response;
    }
}
