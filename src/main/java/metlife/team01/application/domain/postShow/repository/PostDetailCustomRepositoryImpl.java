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
public class PostDetailCustomRepositoryImpl implements PostDetailCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

}
