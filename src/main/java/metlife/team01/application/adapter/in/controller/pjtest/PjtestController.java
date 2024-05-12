package metlife.team01.application.adapter.in.controller.pjtest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.pjtest.model.PjtestRequest;
import metlife.team01.application.biz.pjtest.port.in.PjtestPort;
import metlife.team01.application.util.ResponseMessage;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/ap1/v1/test")
public class PjtestController {

    private final PjtestPort pjtestPort;
    private final MessageSourceAccessor messageSource;


    @PostMapping
    public ResponseMessage postTest(@RequestBody PjtestRequest request) {
        return ResponseMessage.builder()
                .item(pjtestPort.insertTest(request))
                .statusCode(HttpStatus.OK.value())
                .resultMessage(messageSource.getMessage("common.process.complete"))
                .build();
    }


}
