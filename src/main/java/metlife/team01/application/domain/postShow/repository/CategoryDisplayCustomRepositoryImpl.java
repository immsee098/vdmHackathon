package metlife.team01.application.domain.postShow.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.postShow.model.CategoryDisplayResponse;
import metlife.team01.application.adapter.in.controller.postShow.model.QCategoryDisplayResponse;

import static metlife.team01.application.domain.postShow.model.QCategoryDisplayEntity.categoryDisplayEntity;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CategoryDisplayCustomRepositoryImpl implements CategoryDisplayCustomRepository {
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
