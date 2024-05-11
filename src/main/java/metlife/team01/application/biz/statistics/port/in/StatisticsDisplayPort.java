package metlife.team01.application.biz.statistics.port.in;

import metlife.team01.application.adapter.in.controller.statistics.model.AllStatisticsResponse;

import java.util.List;

public interface StatisticsDisplayPort {

    public List<AllStatisticsResponse> getAllStatistics();
}
