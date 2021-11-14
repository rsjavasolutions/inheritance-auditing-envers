package com.rsjava.entityinheritance.farmer;

import com.rsjava.entityinheritance.common.response.SurveyResponse;
import com.rsjava.entityinheritance.farmer.request.FarmerSurveyRequest;
import com.rsjava.entityinheritance.farmer.response.FarmerSurveyHistoryResponse;
import com.rsjava.entityinheritance.farmer.response.FarmerSurveyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("surveys/farmers")
@RequiredArgsConstructor
public class FarmerSurveyController {

    private final FarmerSurveyService farmerSurveyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FarmerSurveyResponse> getSurveys() {
        return farmerSurveyService.getSurveys();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveSurvey(@RequestBody @Valid FarmerSurveyRequest request) {
        return farmerSurveyService.saveSurvey(request);
    }

    @PutMapping("{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    public SurveyResponse updateSurvey(@PathVariable String uuid,
                                       @RequestBody @Valid FarmerSurveyRequest request) {
        return farmerSurveyService.updateSurvey(uuid, request);
    }

    @GetMapping("{uuid}/history")
    public List<FarmerSurveyHistoryResponse> getHistory(@PathVariable String uuid) {
        return farmerSurveyService.getHistory(uuid);
    }
}

