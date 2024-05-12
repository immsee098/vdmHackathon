package metlife.team01.application.adapter.in.controller.chatContentController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.chatContentController.model.ChatContentRequest;
import metlife.team01.application.biz.chatContent.port.in.ChatContentPort;
import metlife.team01.application.util.ResponseMessage;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/communicate")
public class ChatContentController {
    private final ChatContentPort chatContentPort;
    private final MessageSourceAccessor messageSource;

}
