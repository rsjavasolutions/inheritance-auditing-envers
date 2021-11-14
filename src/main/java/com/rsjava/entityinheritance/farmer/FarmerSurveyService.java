package com.rsjava.entityinheritance.farmer;

import com.rsjava.entityinheritance.common.SurveyRepository;
import com.rsjava.entityinheritance.common.exception.SurveyNotFoundException;
import com.rsjava.entityinheritance.farmer.entity.FarmerSurveyEntity;
import com.rsjava.entityinheritance.farmer.mapper.FarmerSurveyMapper;
import com.rsjava.entityinheritance.farmer.request.FarmerSurveyRequest;
import com.rsjava.entityinheritance.farmer.response.FarmerSurveyHistoryResponse;
import com.rsjava.entityinheritance.farmer.response.FarmerSurveyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FarmerSurveyService {

    private final SurveyRepository surveyRepository;
    private final FarmerSurveyRepository farmerSurveyRepository;
    private final FarmerSurveyHistoryRepository farmerSurveyHistoryRepository;

    @Transactional
    public List<FarmerSurveyResponse> getSurveys() {

        return farmerSurveyRepository.findAll()
                .stream()
                .map(FarmerSurveyMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public FarmerSurveyResponse updateSurvey(String uuid, FarmerSurveyRequest request) {
        FarmerSurveyEntity surveyEntity = (FarmerSurveyEntity) surveyRepository.findByUuid(uuid).orElseThrow(() -> new SurveyNotFoundException(uuid));

        surveyEntity.setName(request.getName());
        surveyEntity.setSurname(request.getSurname());
        surveyEntity.setAge(request.getAge());
        surveyEntity.setFieldArea(request.getFieldArea());
        surveyEntity.setTractorModel(request.getTractorModel());

        return FarmerSurveyMapper.mapToResponse(surveyEntity);
    }

    @Transactional
    public String saveSurvey(FarmerSurveyRequest request) {
        log.debug("Save survey request with params: {}", request);

        return surveyRepository.save(FarmerSurveyMapper.mapToEntity(request)).getUuid();
    }

    @Transactional
    public List<FarmerSurveyHistoryResponse> getHistory(String uuid) {
        FarmerSurveyEntity surveyEntity = (FarmerSurveyEntity) surveyRepository.findByUuid(uuid).orElseThrow(() -> new SurveyNotFoundException(uuid));

        List<FarmerSurveyHistoryResponse> historyRevisions = farmerSurveyHistoryRepository.findRevisions(surveyEntity.getId()).get()
                .map(Revision::getEntity)
                .map(FarmerSurveyMapper::mapToHistoryResponse)
                .collect(Collectors.toList());
        Collections.reverse(historyRevisions);

        return historyRevisions;
    }
}