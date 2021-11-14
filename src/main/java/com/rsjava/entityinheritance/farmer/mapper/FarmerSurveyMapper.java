package com.rsjava.entityinheritance.farmer.mapper;

import com.rsjava.entityinheritance.farmer.entity.FarmerSurveyEntity;
import com.rsjava.entityinheritance.farmer.request.FarmerSurveyRequest;
import com.rsjava.entityinheritance.farmer.response.FarmerSurveyHistoryResponse;
import com.rsjava.entityinheritance.farmer.response.FarmerSurveyResponse;

public class FarmerSurveyMapper {

    public static FarmerSurveyEntity mapToEntity(FarmerSurveyRequest request) {
        return new FarmerSurveyEntity(
                request.getName(),
                request.getSurname(),
                request.getAge(),
                request.getFieldArea(),
                request.getTractorModel()
        );
    }

    public static FarmerSurveyResponse mapToResponse(FarmerSurveyEntity entity) {
        return new FarmerSurveyResponse(
                entity.getId(),
                entity.getUuid(),
                entity.getName(),
                entity.getSurname(),
                entity.getAge(),
                entity.getCreatedBy(),
                entity.getCreatedDate(),
                entity.getLastModifiedBy(),
                entity.getLastModifiedDate(),
                entity.getFieldArea(),
                entity.getTractorModel()
        );
    }

    public static FarmerSurveyHistoryResponse mapToHistoryResponse(FarmerSurveyEntity entity) {
        return new FarmerSurveyHistoryResponse(
                entity.getName(),
                entity.getSurname(),
                entity.getAge(),
                entity.getLastModifiedBy(),
                entity.getLastModifiedDate(),
                entity.getFieldArea(),
                entity.getTractorModel()
        );
    }
}
