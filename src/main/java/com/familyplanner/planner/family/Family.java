package com.familyplanner.planner.family;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.familyplanner.planner.member.Member;
import com.familyplanner.planner.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Simple JavaBean domain object representing a family.
 */

@Entity
@Table(name = "families")
public class Family extends BaseEntity {
    @Column(name = "last_name")
    @NotEmpty
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "family")
    @JsonIgnoreProperties("family")
    private Set<Member> members;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

}
