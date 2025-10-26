package repository;

import entity.PhantomAgentTaskEntity;
import model.enums.PhantomAgentTaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PhantomAgentTaskRepository extends JpaRepository<PhantomAgentTaskEntity, UUID> {
    List<PhantomAgentTaskEntity> findAllByPhantomAgentTaskStatus(PhantomAgentTaskStatus status);
}
