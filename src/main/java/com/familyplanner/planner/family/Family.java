package com.familyplanner.planner.family;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.familyplanner.planner.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

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

    protected Set<Member> getMembersInternal() {
        if (this.members == null) {
            this.members = new HashSet<>();
        }
        return this.members;
    }

    public List<Member> getMembers() {
        List<Member> sortedMembers = new ArrayList<>(getMembersInternal());
        PropertyComparator.sort(sortedMembers, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedMembers);
    }


    public void setMembers(Set<Member> members) {
        this.members = members;
    }

}
