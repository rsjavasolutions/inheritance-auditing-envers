package com.rsjava.entityinheritance.common;

import com.rsjava.entityinheritance.common.model.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyEntity, Long> {

    Optional<SurveyEntity> findByUuid(String uuid);
}
