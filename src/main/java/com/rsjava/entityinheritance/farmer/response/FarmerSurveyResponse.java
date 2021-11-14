package com.rsjava.entityinheritance.farmer.response;

import com.rsjava.entityinheritance.common.response.SurveyResponse;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class FarmerSurveyResponse extends SurveyResponse {
    private BigDecimal fieldArea;
    private String tractorModel;

    public FarmerSurveyResponse(long id,
                                String uuid,
                                String name,
                                String surname,
                                int age,
                                String createdBy,
                                LocalDateTime createdDate,
                                String lastModifiedBy,
                                LocalDateTime lastModifiedDate,
                                BigDecimal fieldArea,
                                String tractorModel) {
        super(id, uuid, name, surname, age, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.fieldArea = fieldArea;
        this.tractorModel = tractorModel;
    }
}
