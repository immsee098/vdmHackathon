package metlife.team01.application.biz.postShow.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.postShow.model.*;
import metlife.team01.application.biz.postShow.port.in.CategoryDisplayPort;
import metlife.team01.application.biz.postShow.port.in.PostShowPort;
import metlife.team01.application.domain.postShow.model.PostDetailShowEntity;
import metlife.team01.application.domain.postShow.model.PostMasterShowEntity;
import metlife.team01.application.domain.postShow.model.PostPasswordEntity;
import metlife.team01.application.domain.postShow.repository.CategoryDisplayJpaRepository;
import metlife.team01.application.domain.postShow.repository.PostDetailJpaRepository;
import metlife.team01.application.domain.postShow.repository.PostMasterJpaRepository;
import metlife.team01.application.domain.postShow.repository.PostPasswordJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostShowService implements PostShowPort {

    private final PostMasterJpaRepository postMasterJpaRepository;
    private final PostDetailJpaRepository postDetailJpaRepository;
    private final PostPasswordJpaRepository postPasswordJpaRepository;


    @Override
    @Transactional
    public Page<PostShowMasterResponse> getPostList(String ordrType, Pageable pageable) {
        PostShowMasterRequest request = new PostShowMasterRequest();
        request.setOrdrBy(ordrType);

        return postMasterJpaRepository.getPostListMaster(request, pageable);
    }

    @Override
    @Transactional
    public long insertNewPost(PostShowDetailRequest request) {

        try {
            // 마스터 정보
            long postId = postMasterJpaRepository.save(
                    new PostMasterShowEntity().saveEntity(
                            request.getPostTitle()
                            , "N"
                    )
            ).getPostId();

            // 디테일 정보
            postDetailJpaRepository.save(
                    new PostDetailShowEntity().saveEntity(
                            postId
                            , request.getPostContent()
                            , "N"
                    )
            );

            // 암호
            String password = Base64.getEncoder().encodeToString(request.getPassword().getBytes());

            postPasswordJpaRepository.save(
                    new PostPasswordEntity().saveEntity(
                            postId
                            , password
                    )
            );

            return postId;

        } catch (Exception e) {
            return -1;
        }
    }


}
