package com.rsjava.entityinheritance.common;

import com.rsjava.entityinheritance.common.request.SurveyRequest;
import com.rsjava.entityinheritance.common.response.SurveyHistoryResponse;
import com.rsjava.entityinheritance.common.response.SurveyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("surveys")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveryService surveryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SurveyResponse> getSurveys() {
        return surveryService.getSurveys();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveSurvey(@RequestBody @Valid SurveyRequest request) {
        return surveryService.saveSurvey(request);
    }

    @PutMapping("{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    public SurveyResponse updateSurvey(@PathVariable String uuid,
                                       @RequestBody @Valid SurveyRequest request) {
        return surveryService.updateSurvey(uuid, request);
    }

    @GetMapping("{uuid}/history")
    public List<SurveyHistoryResponse> getHistory(@PathVariable String uuid) {
        return surveryService.getHistory(uuid);
    }
}
