package com.rsjava.entityinheritance.common;

import com.rsjava.entityinheritance.common.exception.SurveyNotFoundException;
import com.rsjava.entityinheritance.common.mapper.SurveryMapper;
import com.rsjava.entityinheritance.common.model.SurveyEntity;
import com.rsjava.entityinheritance.common.request.SurveyRequest;
import com.rsjava.entityinheritance.common.response.SurveyHistoryResponse;
import com.rsjava.entityinheritance.common.response.SurveyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.rsjava.entityinheritance.common.mapper.SurveryMapper.mapToEntity;
import static com.rsjava.entityinheritance.common.mapper.SurveryMapper.mapToResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurveryService {

    private final SurveyRepository surveyRepository;
    private final SurveyHistoryRepository surveyHistoryRepository;

    @Transactional
    public List<SurveyResponse> getSurveys() {

        return surveyRepository.findAll()
                .stream()
                .map(SurveryMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public SurveyResponse updateSurvey(String uuid, SurveyRequest request) {
        SurveyEntity surveyEntity = surveyRepository.findByUuid(uuid).orElseThrow(() -> new SurveyNotFoundException(uuid));

        surveyEntity.setName(request.getName());
        surveyEntity.setSurname(request.getSurname());
        surveyEntity.setAge(request.getAge());

        return mapToResponse(surveyEntity);
    }

    @Transactional
    public String saveSurvey(SurveyRequest request) {
        log.debug("Save survey request with params: {}", request);

        return surveyRepository.save(mapToEntity(request)).getUuid();
    }

    @Transactional
    public List<SurveyHistoryResponse> getHistory(String uuid) {
        SurveyEntity surveyEntity = surveyRepository.findByUuid(uuid).orElseThrow(() -> new SurveyNotFoundException(uuid));

        List<SurveyHistoryResponse> historyRevisions = surveyHistoryRepository.findRevisions(surveyEntity.getId()).get()
                .map(Revision::getEntity)
                .map(SurveryMapper::mapToHistoryResponse)
                .collect(Collectors.toList());
        Collections.reverse(historyRevisions);

        return historyRevisions;
    }
}
