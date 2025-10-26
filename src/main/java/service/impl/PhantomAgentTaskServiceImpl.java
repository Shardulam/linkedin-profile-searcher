package service.impl;

import entity.PhantomAgentTaskEntity;
import lombok.RequiredArgsConstructor;
import model.request.LinkedInProfileSearchDTO;
import repository.PhantomAgentTaskRepository;
import service.PhantomAgentTaskService;
import service.mapper.GenericModelMapper;

import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
public class PhantomAgentTaskServiceImpl implements PhantomAgentTaskService {

    private final GenericModelMapper modelMapper;

    private final PhantomAgentTaskRepository taskRepository;

    @Override
    public UUID createPhantomBulkConsentTask(String containerId, LinkedInProfileSearchDTO linkedInProfileSearchDTO) {
        PhantomAgentTaskEntity entity = modelMapper.map(containerId, linkedInProfileSearchDTO);
        return taskRepository.save(entity).getId();
    }

    @Override
    public Optional<PhantomAgentTaskEntity> findPhantomAgentTaskByTrackingId(UUID trackingId) {
        return taskRepository.findById(trackingId);
    }
}
