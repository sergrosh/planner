package com.familyplanner.planner.service;

import java.util.Collection;

import com.familyplanner.planner.family.Family;
import com.familyplanner.planner.family.FamilyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
class PlannerServiceTest {

    @Autowired
    private FamilyRepository families;


    @Test
    void shouldFindFamiliesByLastName() {
        Collection<Family> families = this.families.findByLastName("Jenk");
        assertThat(families).hasSize(2);

        families = this.families.findByLastName("Daviss");
        assertThat(families).isEmpty();
    }

    @Test
    void shouldFindSingleFamilyWithMembers() {
        Family family = this.families.findById(1);
        assertThat(family.getLastName()).startsWith("Joh");
        assertThat(family.getMembers()).hasSize(2);
        assertThat(family.getMembers().get(0)).isNotNull();
        assertThat(family.getMembers().get(0).getName()).isEqualTo("Helen");
    }

    @Test
    @Transactional
    void shouldInsertFamily() {
        Collection<Family> families = this.families.findByLastName("Johns");
        int found = families.size();

        Family family = new Family();
        family.setLastName("Johns");
        this.families.save(family);
        assertThat(family.getId().longValue()).isNotZero();

        families = this.families.findByLastName("Johns");
        assertThat(families).hasSize(found + 1);
    }

    @Test
    @Transactional
    void shouldUpdateFamily() {
        Family family = this.families.findById(1);
        String oldLastName = family.getLastName();
        String newLastName = oldLastName + "X";

        family.setLastName(newLastName);
        this.families.save(family);

        // retrieving new name from database
        family = this.families.findById(1);
        assertThat(family.getLastName()).isEqualTo(newLastName);
    }
}
