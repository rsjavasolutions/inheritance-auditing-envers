package com.rsjava.entityinheritance.farmer.entity;

import com.rsjava.entityinheritance.common.model.SurveyEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "farmer_survey")
@PrimaryKeyJoinColumn(name = "survey_id", referencedColumnName = "id")
@Audited
public class FarmerSurveyEntity extends SurveyEntity {
    private BigDecimal fieldArea;
    private String tractorModel;

    public FarmerSurveyEntity(String name,
                              String surname,
                              int age,
                              BigDecimal fieldArea,
                              String tractorModel) {
        super(name, surname, age);
        this.fieldArea = fieldArea;
        this.tractorModel = tractorModel;
    }
}
