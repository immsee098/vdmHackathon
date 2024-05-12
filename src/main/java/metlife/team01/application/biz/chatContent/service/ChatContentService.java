package metlife.team01.application.biz.chatContent.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.chatContentController.model.ChatContentRequest;
import metlife.team01.application.biz.chatContent.port.in.ChatContentPort;
import metlife.team01.application.domain.postShow.repository.CategoryDisplayJpaRepository;
import metlife.team01.application.domain.chatContent.model.ChatContentEntity;
import metlife.team01.application.domain.chatContent.repository.ChatContentJpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatContentService implements ChatContentPort {

    private final ChatContentJpaRepository chatContentJpaRepository;
    private final CategoryDisplayJpaRepository categoryDisplayJpaRepository;

    @Override
    @Async
    public void insertChatContent(ChatContentRequest request) {
        chatContentJpaRepository.save(
                new ChatContentEntity(
                        request.getRoomId(),
                        request.getContent(),
                        request.getCodeNum(),
                        "N"
                )
        );
    }
}
