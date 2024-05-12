package metlife.team01.application.biz.chatContent.port.in;

import metlife.team01.application.adapter.in.controller.chatContentController.model.ChatContentRequest;
import org.springframework.scheduling.annotation.Async;

public interface ChatContentPort {

    @Async
    public void insertChatContent(ChatContentRequest chatContentRequest);


}
