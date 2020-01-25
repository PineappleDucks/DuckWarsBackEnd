package de.fh.dortmund.pineappleducks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conditionId;

    private String conditionDescriptor;
    private Boolean conditionStatus;

    public Long getConditionId() {
        return conditionId;
    }

    public void setConditionId(Long conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionDescriptor() {
        return conditionDescriptor;
    }

    public void setConditionDescriptor(String conditionDescriptor) {
        this.conditionDescriptor = conditionDescriptor;
    }

    public Boolean getConditionStatus() {
        return conditionStatus;
    }

    public void setConditionStatus(Boolean conditionStatus) {
        this.conditionStatus = conditionStatus;
    }
}
