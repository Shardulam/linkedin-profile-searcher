package service;

import entity.PhantomAgentTaskEntity;
import model.request.LinkedInProfileSearchDTO;

import java.util.Optional;
import java.util.UUID;

public interface PhantomAgentTaskService {

    UUID createPhantomBulkConsentTask(String containerId, LinkedInProfileSearchDTO linkedInProfileSearchDTO);

    Optional<PhantomAgentTaskEntity> findPhantomAgentTaskByTrackingId(UUID trackingId);
}
