package metlife.team01.application.adapter.in.controller.categoryDisplay;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.categoryDisplay.model.CategoryDisplayRequest;
import metlife.team01.application.biz.categoryDisplay.port.in.CategoryDisplayPort;
import metlife.team01.application.util.ResponseMessage;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/availableCategory")
public class CategoryDisplayController {

    private final CategoryDisplayPort categoryDisplayPort;
    private final MessageSourceAccessor messageSource;

    @PostMapping
    public ResponseMessage getCategoryByMenuLvl(@RequestBody CategoryDisplayRequest request,
                                                @RequestHeader("UUID_per") String UUID) {

        return ResponseMessage.builder()
                .item(categoryDisplayPort.getCategoryByMenuLevel(request))
                .statusCode(HttpStatus.OK.value())
                .resultMessage(messageSource.getMessage("common.process.complete"))
                .build();
    }

}
