package service.impl;

import lombok.RequiredArgsConstructor;
import model.phantom.buster.PhantomLaunchResponse;
import model.request.LinkedInProfileSearchDTO;
import model.response.SuccessResponseVO;
import service.PhantomAgentTaskService;
import service.PhantomBusterService;
import service.client.PhantomBusterClient;

import java.util.UUID;

@RequiredArgsConstructor
public class PhantomBusterServiceImpl implements PhantomBusterService {

    private final PhantomBusterClient phantomBusterClient;

    private final PhantomAgentTaskService phantomAgentTaskService;

    @Override
    public SuccessResponseVO<Object> searchLinkedInProfiles(LinkedInProfileSearchDTO linkedInProfileSearchDTO) {
        PhantomLaunchResponse phantomLaunchResponse = phantomBusterClient
                .triggerPhantomBusterSearch(linkedInProfileSearchDTO.getCurrentDesignation(),
                        linkedInProfileSearchDTO.getUniversity());
        UUID trackingId = phantomAgentTaskService.createPhantomBulkConsentTask(phantomLaunchResponse.getContainerId(),
                linkedInProfileSearchDTO);
        return SuccessResponseVO.of("Phantom to scrap linkedIn data launched successfully. " +
                "You can access your data using result api by passing given tracking id with in few minutes", trackingId);
    }
}