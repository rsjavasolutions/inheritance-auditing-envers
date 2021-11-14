package com.rsjava.entityinheritance.common;

import com.rsjava.entityinheritance.common.model.SurveyEntity;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyHistoryRepository extends RevisionRepository<SurveyEntity, Long, Long> {
}
