package metlife.team01.application.domain.chatContent.repository;

import metlife.team01.application.domain.chatContent.model.ChatContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatContentJpaRepository extends JpaRepository<ChatContentEntity, Long>, ChatContentCustomRepository {
}
