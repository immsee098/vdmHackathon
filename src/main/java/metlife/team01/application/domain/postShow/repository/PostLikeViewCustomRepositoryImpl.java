package metlife.team01.application.domain.postShow.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.postShow.model.PostLikeViewResponse;
import metlife.team01.application.adapter.in.controller.postShow.model.QPostLikeViewResponse;
import metlife.team01.application.domain.postShow.model.QPostLikeViewEntity;

import static metlife.team01.application.domain.postShow.model.QPostLikeViewEntity.postLikeViewEntity;

@Slf4j
@RequiredArgsConstructor
public class PostLikeViewCustomRepositoryImpl implements PostLikeViewCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public PostLikeViewResponse getPostLikeViewInfo(long postId) {
        return jpaQueryFactory
                .select(new QPostLikeViewResponse(
                        QPostLikeViewEntity.postLikeViewEntity
                        ))
                .from(postLikeViewEntity)
                .where(postLikeViewEntity.postId.eq(postId))
                .fetchOne();
    }
}
