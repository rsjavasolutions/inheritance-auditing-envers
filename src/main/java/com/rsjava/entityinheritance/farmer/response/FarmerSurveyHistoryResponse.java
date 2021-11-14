package com.rsjava.entityinheritance.farmer.response;

import com.rsjava.entityinheritance.common.response.SurveyHistoryResponse;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class FarmerSurveyHistoryResponse extends SurveyHistoryResponse {
    private final BigDecimal fieldArea;
    private final String tractorModel;

    public FarmerSurveyHistoryResponse(String name,
                                       String surname,
                                       int age,
                                       String modifiedBy,
                                       LocalDateTime modifiedDate,
                                       BigDecimal fieldArea,
                                       String tractorModel) {
        super(name, surname, age, modifiedBy, modifiedDate);
        this.fieldArea = fieldArea;
        this.tractorModel = tractorModel;
    }
}
