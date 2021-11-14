package com.rsjava.entityinheritance.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class SurveyHistoryResponse {
    private String name;
    private String surname;
    private int age;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
}
