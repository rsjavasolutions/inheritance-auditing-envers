package com.rsjava.entityinheritance.farmer;

import com.rsjava.entityinheritance.farmer.entity.FarmerSurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerSurveyRepository extends JpaRepository<FarmerSurveyEntity, Long> {
}
