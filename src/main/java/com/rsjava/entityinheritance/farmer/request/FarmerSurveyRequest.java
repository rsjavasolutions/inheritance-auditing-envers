package com.rsjava.entityinheritance.farmer.request;

import com.rsjava.entityinheritance.common.request.SurveyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FarmerSurveyRequest extends SurveyRequest {
    @DecimalMin(value = "0.0")
    private BigDecimal fieldArea;
    @NotNull
    private String tractorModel;
}
