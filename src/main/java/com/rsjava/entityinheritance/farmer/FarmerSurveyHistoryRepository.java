package com.rsjava.entityinheritance.farmer;

import com.rsjava.entityinheritance.farmer.entity.FarmerSurveyEntity;
import org.springframework.data.repository.history.RevisionRepository;

public interface FarmerSurveyHistoryRepository extends RevisionRepository<FarmerSurveyEntity, Long, Long> {
}
