package metlife.team01.application.adapter.in.controller.postShow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.postShow.model.CategoryDisplayRequest;
import metlife.team01.application.adapter.in.controller.postShow.model.PostShowDetailRequest;
import metlife.team01.application.adapter.in.controller.postShow.model.PostShowMasterRequest;
import metlife.team01.application.biz.postShow.port.in.CategoryDisplayPort;
import metlife.team01.application.biz.postShow.port.in.PostShowPort;
import metlife.team01.application.util.ResponseMessage;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/post")
public class PostShowController {

    private final PostShowPort postShowPort;
    private final MessageSourceAccessor messageSource;

    @GetMapping(value = "/list")
    public ResponseMessage getPostList(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String ordr
    ) {
        Pageable pageable = PageRequest.of(page, size);

        return ResponseMessage.builder()
                .item(postShowPort.getPostList(ordr, pageable).getContent())
                .statusCode(HttpStatus.OK.value())
                .resultMessage(messageSource.getMessage("common.process.complete"))
                .build();
    }

    @GetMapping(value = "/id/{id}")
    public ResponseMessage getPostDetail(
            @PathVariable Integer id
    ) {
        return ResponseMessage.builder()
                .item(postShowPort.getDetailPost(id))
                .statusCode(HttpStatus.OK.value())
                .resultMessage(messageSource.getMessage("common.process.complete"))
                .build();
    }

    @PostMapping
    public ResponseMessage insertNewPost(@RequestBody PostShowDetailRequest request) {

        return ResponseMessage.builder()
                .item(postShowPort.insertNewPost(request))
                .statusCode(HttpStatus.OK.value())
                .resultMessage(messageSource.getMessage("common.process.complete"))
                .build();
    }

    @PostMapping("/modify")
    public ResponseMessage updatePost(@RequestBody PostShowDetailRequest request) {

        return ResponseMessage.builder()
                .item(postShowPort.updatePost(request))
                .statusCode(HttpStatus.OK.value())
                .resultMessage(messageSource.getMessage("common.process.complete"))
                .build();
    }

}
