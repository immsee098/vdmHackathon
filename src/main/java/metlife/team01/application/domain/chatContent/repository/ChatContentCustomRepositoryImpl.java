package metlife.team01.application.domain.chatContent.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ChatContentCustomRepositoryImpl implements ChatContentCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

}
