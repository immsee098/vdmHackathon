package metlife.team01.application.biz.chatContent.port.in;

import metlife.team01.application.adapter.in.controller.categoryDisplay.model.CategoryDisplayResponse;
import metlife.team01.application.adapter.in.controller.chatContentController.model.ChatContentRequest;
import metlife.team01.application.adapter.in.controller.chatContentController.model.ChatContentResponse;
import org.springframework.scheduling.annotation.Async;

public interface ChatContentPort {

    @Async
    public void insertChatContent(ChatContentRequest chatContentRequest);

    public CategoryDisplayResponse chatContentResponse(ChatContentRequest request, String header);

}
