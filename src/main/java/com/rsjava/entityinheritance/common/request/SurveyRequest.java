package com.rsjava.entityinheritance.common.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SurveyRequest implements Serializable {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    @Positive
    private Integer age;
}
