package metlife.team01.application.domain.postShow.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.postShow.model.*;
import metlife.team01.application.domain.postShow.model.QPostLikeViewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import java.util.ArrayList;
import java.util.List;

import static metlife.team01.application.domain.postShow.model.QCategoryDisplayEntity.categoryDisplayEntity;
import static metlife.team01.application.domain.postShow.model.QPostMasterShowEntity.postMasterShowEntity;

@Slf4j
@RequiredArgsConstructor
public class PostMasterCustomRepositoryImpl implements PostMasterCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<CategoryDisplayResponse> findByLevelOrderByModifyAt(Integer menuLvl) {
        List<CategoryDisplayResponse> result = jpaQueryFactory
                .select(
                        new QCategoryDisplayResponse(categoryDisplayEntity,categoryDisplayEntity.menuLevel)
                )
                .from(categoryDisplayEntity)
                .where(eqMenuLevel(menuLvl).and(categoryDisplayEntity.deleteYn.eq("N")))
//                .orderBy(categoryDisplayEntity.modifyAt.asc())
                .fetch();


        return result;
    }

    @Override
    public List<CategoryDisplayResponse> findByParentCodeNumandLevel(Integer parentCodeNum, Integer menulvl) {
        List<CategoryDisplayResponse> result = jpaQueryFactory
                .select(
                        new QCategoryDisplayResponse(categoryDisplayEntity, categoryDisplayEntity.parentCodeNum, categoryDisplayEntity.menuLevel)
                )
                .from(categoryDisplayEntity)
                .where(eqMenuLevel(menulvl)
                        .and(categoryDisplayEntity.parentCodeNum.eq(parentCodeNum))
                        .and(categoryDisplayEntity.deleteYn.eq("N")))
//                .orderBy(categoryDisplayEntity.modifyAt.asc())
                .fetch();

        return result;
    }

    @Override
    public List<CategoryDisplayResponse> findCategoryByCategoryName(String categoryName) {
        List<CategoryDisplayResponse> result = jpaQueryFactory
                .select(
                        new QCategoryDisplayResponse(categoryDisplayEntity, categoryDisplayEntity.codeName)
                )
                .from(categoryDisplayEntity)
                .where(eqCodeName(categoryName)
                        .and(categoryDisplayEntity.deleteYn.eq("N")))
                .limit(1)
                .fetch();

        return result;

    }

    @Override
    public Page<PostShowMasterResponse> getPostListMaster(PostShowMasterRequest request, Pageable pageable) {

        // TODO 코드분리
        List<PostShowMasterResponse> content = jpaQueryFactory
                .select(new QPostShowMasterResponse(postMasterShowEntity
                        , QPostLikeViewEntity.postLikeViewEntity.likeCount
                        , QPostLikeViewEntity.postLikeViewEntity.viewCount
                ))
                .from(postMasterShowEntity, QPostLikeViewEntity.postLikeViewEntity)
                .where(postMasterShowEntity.postId.eq(QPostLikeViewEntity.postLikeViewEntity.postId)
                        .and(postMasterShowEntity.dltYn.eq("N")))
                .orderBy(displayShowMaster(request))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = jpaQueryFactory.select(postMasterShowEntity.count())
                .from(postMasterShowEntity)
                .where(postMasterShowEntity.dltYn.eq("N"))
                .fetchOne();

        return new PageImpl<>(content, pageable, count);
    }

    private OrderSpecifier[] displayShowMaster(PostShowMasterRequest request) {
        List<OrderSpecifier> orderSpecifiers = new ArrayList<>();

        if ("DATE".equals(request.getOrdrBy())) {
            orderSpecifiers.add(new OrderSpecifier(Order.DESC, postMasterShowEntity.crtdDate));
        } else if ("LIKE".equals(request.getOrdrBy())) {
            orderSpecifiers.add(new OrderSpecifier(Order.DESC, QPostLikeViewEntity.postLikeViewEntity.likeCount));
        } else if ("VIEW".equals(request.getOrdrBy())) {
            orderSpecifiers.add(new OrderSpecifier(Order.DESC, QPostLikeViewEntity.postLikeViewEntity.viewCount));
        }

        return orderSpecifiers.toArray(new OrderSpecifier[orderSpecifiers.size()]);

    }

    private BooleanExpression eqMenuLevel(Integer menulLevel) {
        if (menulLevel == null) {
            return null;
        }
        return categoryDisplayEntity.menuLevel.eq(menulLevel);
    }

    private BooleanExpression eqCodeName(String codeName) {
        if (StringUtils.isBlank(codeName)) {
            return null;
        }
        return categoryDisplayEntity.codeName.eq(codeName);
    }
}
