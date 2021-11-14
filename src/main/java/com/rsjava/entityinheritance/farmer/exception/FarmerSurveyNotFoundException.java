package com.rsjava.entityinheritance.farmer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class FarmerSurveyNotFoundException extends RuntimeException {

    private final static String MESSAGE = "Can't find farmer survey with uuid: %s";

    public FarmerSurveyNotFoundException(String uuid) {
        super(String.format(MESSAGE, uuid));
        log.debug(String.format(MESSAGE, uuid));
    }
}