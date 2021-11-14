package com.rsjava.entityinheritance.common.model;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rev_info")
@RevisionEntity
public class RevInfo extends DefaultRevisionEntity {

}