package com.rsjava.entityinheritance.common.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "survey")
@Audited
public class SurveyEntity extends AbstractAuditingEntity {
    @Column(unique = true, updatable = false)
    @Setter(AccessLevel.NONE)
    private String uuid;
    private String name;
    private String surname;
    private int age;

    public SurveyEntity(String name, String surname, int age) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
