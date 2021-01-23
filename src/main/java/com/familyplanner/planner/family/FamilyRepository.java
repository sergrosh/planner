package com.familyplanner.planner.family;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository class for <code>Family</code> domain objects
 */
public interface FamilyRepository extends Repository<Family, Integer> {
    /**
     * Retrieve {@link Family}s from the data store by last name, returning all families
     * whose last name <i>starts</i> with the given name.
     * @param lastName Value to search for
     * @return a Collection of matching {@link Family}s (or an empty Collection if none
     * found)
     */
    @Query("SELECT DISTINCT family FROM Family family left join fetch family.members WHERE family.lastName LIKE :lastName%")
    @Transactional(readOnly = true)
    Collection<Family> findByLastName(@Param("lastName") String lastName);
}
