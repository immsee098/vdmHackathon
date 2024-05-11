package metlife.team01.application.adapter.in.controller.pjtest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.pjtest.model.PjtestRequest;
import metlife.team01.application.biz.pjtest.port.in.PjtestPort;
import metlife.team01.application.util.OpenAiProvider;
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

    @GetMapping
    public ResponseMessage getTestList(@RequestBody PjtestRequest request){
        OpenAiProvider provider = new OpenAiProvider();

        return ResponseMessage.builder()
                .item(provider.request("죽을 때까지 보장되는 보험 목록이 궁금해", "종신 보험/생명 보험"))
//                        .item(pjtestPort.getTestList(request))
                .statusCode(HttpStatus.OK.value())
                .resultMessage(messageSource.getMessage("common.process.complete"))
                .build();
    }

    @PostMapping
    public ResponseMessage postTest(@RequestBody PjtestRequest request) {
        return ResponseMessage.builder()
                .item(pjtestPort.insertTest(request))
                .statusCode(HttpStatus.OK.value())
                .resultMessage(messageSource.getMessage("common.process.complete"))
                .build();
    }


}
