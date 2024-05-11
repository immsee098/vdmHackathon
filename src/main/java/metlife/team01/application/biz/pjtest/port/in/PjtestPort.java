package metlife.team01.application.biz.pjtest.port.in;

import metlife.team01.application.adapter.in.controller.pjtest.model.PjtestRequest;
import metlife.team01.application.adapter.in.controller.pjtest.model.PjtestResponse;

import java.util.List;

public interface PjtestPort {
    public List<PjtestResponse> getTestList(PjtestRequest request);

    public boolean insertTest(PjtestRequest request);
}
