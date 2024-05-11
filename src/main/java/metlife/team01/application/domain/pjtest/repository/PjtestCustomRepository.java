package metlife.team01.application.domain.pjtest.repository;

import metlife.team01.application.adapter.in.controller.pjtest.model.PjtestResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PjtestCustomRepository {
    List<PjtestResponse> findByFirstNameAndLastName(
            String firstName,
            String lastName
    );
}
