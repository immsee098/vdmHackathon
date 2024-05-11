package metlife.team01.application.adapter.in.controller.statistics.model;

import java.util.List;

public record AllStatisticsResponse(

        Integer  statisticsNum,
        String category,
        Integer userCallCount,
        List<StatisticResponse> subCategory
) {
}
