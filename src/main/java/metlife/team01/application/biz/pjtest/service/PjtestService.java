package metlife.team01.application.biz.pjtest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metlife.team01.application.adapter.in.controller.pjtest.model.PjtestRequest;
import metlife.team01.application.adapter.in.controller.pjtest.model.PjtestResponse;
import metlife.team01.application.biz.pjtest.port.in.PjtestPort;
import metlife.team01.application.domain.pjtest.model.PjtestEntity;
import metlife.team01.application.domain.pjtest.repository.PjtestJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PjtestService implements PjtestPort {

    private final PjtestJpaRepository pjtestJpaRepository;

    @Transactional
    @Override
    public List<PjtestResponse> getTestList(PjtestRequest request) {
        return pjtestJpaRepository.findByFirstNameAndLastName(
                request.getFirstName(),
                request.getLastName()
        );
    }

    @Override
//    @Transactional
    public boolean insertTest(PjtestRequest request) {
        pjtestJpaRepository.save(
                new PjtestEntity(
                        request.getBirthDate(),
                        request.getFirstName(),
                        request.getLastName(),
                        request.getGender(),
                        request.getHireDate()
                )
        );

        return  true;
    }
}
