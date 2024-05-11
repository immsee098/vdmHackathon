package metlife.team01.application.domain.pjtest.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.pjtest.model.PjtestResponse;
import metlife.team01.application.adapter.in.controller.pjtest.model.QPjtestResponse;
import metlife.team01.application.domain.pjtest.model.PjtestEntity;
import metlife.team01.application.domain.pjtest.model.QPjtestEntity;

import java.util.ArrayList;
import java.util.List;

import static metlife.team01.application.domain.pjtest.model.QPjtestEntity.pjtestEntity;


@Slf4j
@RequiredArgsConstructor
public class PjtestCustomRepositoryImpl implements PjtestCustomRepository {

    /**
     * DML 생성을위한 Querydsl 팩토리 클래스
     */
    private final JPAQueryFactory readerJpaQueryFactory;
    private final JPAQueryFactory writerJpaQueryFactory;

    @Override
    public List<PjtestResponse> findByFirstNameAndLastName(String firstName, String lastName) {
//        final QPjtestEntity qPjtestEntity = pjtestEntity;
        List<PjtestResponse> result= readerJpaQueryFactory
                .select(
                        new QPjtestResponse(pjtestEntity, pjtestEntity.firstName, pjtestEntity.lastName)
                )
                .from(pjtestEntity)
                .where(pjtestEntity.firstName.contains(firstName))
                .orderBy(pjtestEntity.empNo.desc())
                .limit(10)
                .fetch();

        return result;
    }
}
