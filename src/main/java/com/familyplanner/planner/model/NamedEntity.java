package com.familyplanner.planner.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class NamedEntity extends BaseEntity {
    @Column(name = "name")
    @NotEmpty
    private String name;

    @Override
    public String toString() {
        return this.getName();
    }
}
