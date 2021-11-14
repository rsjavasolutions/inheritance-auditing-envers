package com.rsjava.entityinheritance.common.mapper;

import com.rsjava.entityinheritance.common.model.SurveyEntity;
import com.rsjava.entityinheritance.common.request.SurveyRequest;
import com.rsjava.entityinheritance.common.response.SurveyHistoryResponse;
import com.rsjava.entityinheritance.common.response.SurveyResponse;

public class SurveryMapper {

    public static SurveyEntity mapToEntity(SurveyRequest request) {
        return new SurveyEntity(
                request.getName(),
                request.getSurname(),
                request.getAge()
        );
    }

    public static SurveyResponse mapToResponse(SurveyEntity entity) {
        return new SurveyResponse(
                entity.getId(),
                entity.getUuid(),
                entity.getName(),
                entity.getSurname(),
                entity.getAge(),
                entity.getCreatedBy(),
                entity.getCreatedDate(),
                entity.getLastModifiedBy(),
                entity.getLastModifiedDate()
        );
    }

    public static SurveyHistoryResponse mapToHistoryResponse(SurveyEntity entity) {
        return new SurveyHistoryResponse(
                entity.getName(),
                entity.getSurname(),
                entity.getAge(),
                entity.getLastModifiedBy(),
                entity.getLastModifiedDate()
        );
    }
}
