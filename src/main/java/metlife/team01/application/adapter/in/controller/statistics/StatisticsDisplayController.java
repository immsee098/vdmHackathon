package metlife.team01.application.adapter.in.controller.statistics;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.biz.statistics.port.in.StatisticsDisplayPort;
import metlife.team01.application.util.ResponseMessage;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/statistics")
public class StatisticsDisplayController {

    private final StatisticsDisplayPort statisticsDisplayPort;
    private final MessageSourceAccessor messageSource;

    @PostMapping
    public ResponseMessage getCategoryByMenuLvl() {

        return ResponseMessage.builder()
                .item(statisticsDisplayPort.getAllStatistics())
                .statusCode(HttpStatus.OK.value())
                .resultMessage(messageSource.getMessage("common.process.complete"))
                .build();
    }
}
