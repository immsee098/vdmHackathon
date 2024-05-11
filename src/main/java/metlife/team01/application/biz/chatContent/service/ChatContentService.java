package metlife.team01.application.biz.chatContent.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.categoryDisplay.model.CategoryDisplayResponse;
import metlife.team01.application.adapter.in.controller.chatContentController.model.ChatContentRequest;
import metlife.team01.application.adapter.in.controller.chatContentController.model.ChatContentResponse;
import metlife.team01.application.biz.chatContent.port.in.ChatContentPort;
import metlife.team01.application.domain.categoryDisplay.repository.CategoryDisplayJpaRepository;
import metlife.team01.application.domain.chatContent.model.ChatContentEntity;
import metlife.team01.application.domain.chatContent.repository.ChatContentJpaRepository;
import metlife.team01.application.util.OpenAiProvider;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public CategoryDisplayResponse chatContentResponse(ChatContentRequest request, String header) {
        OpenAiProvider provider = new OpenAiProvider();
        String categoryStr = "";
        String finalCategoryStr = "";

        // 중간 카테고리 전체 호출(검색 조건 세팅용)
        List<CategoryDisplayResponse> twoDepthList
                = categoryDisplayJpaRepository.findByParentCodeNumandLevel(request.getParentCodeNum(), 2);

        for(CategoryDisplayResponse item : twoDepthList) {
            categoryStr += (item.getCodeName() + "/");
        }

        // GPT API 호출
        String response = provider.request(request.getContent(), categoryStr);


        // 호출에 따른 문자열 처리
        for(CategoryDisplayResponse item : twoDepthList) {
            if(response.contains(item.getCodeName())) {
                finalCategoryStr = item.getCodeName();
                break;
            }
        }

        if (!"".equals(finalCategoryStr)) {
            // 최종 카테고리 값
            List<CategoryDisplayResponse> resultCategory
                    = categoryDisplayJpaRepository.findCategoryByCategoryName(finalCategoryStr);

            if(!resultCategory.isEmpty()) {
                // 통계값 insert
                request.setCodeNum(finalCategoryStr);
                request.setRoomId(header);
                insertChatContent(request);
                return resultCategory.get(0);
            }
        }

        return new CategoryDisplayResponse("대답할 수 없는 질문입니다, 다시 질문해주세요.");
    }
}
