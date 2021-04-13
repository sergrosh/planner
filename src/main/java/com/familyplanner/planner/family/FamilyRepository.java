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
     *
     * @param lastName Value to search for
     * @return a Collection of matching {@link Family}s (or an empty Collection if none
     * found)
     */
    @Query("SELECT DISTINCT family FROM Family family left join fetch family.members WHERE family.lastName LIKE :lastName%")
    @Transactional(readOnly = true)
    Collection<Family> findByLastName(@Param("lastName") String lastName);

    /**
     * Retrieve an {@link Family} from the data store by id.
     *
     * @param id the id to search for
     * @return the {@link Family} if found
     */
    @Query("SELECT family FROM Family family left join fetch family.members WHERE family.id =:id")
    @Transactional(readOnly = true)
    Family findById(@Param("id") Integer id);

    /**
     * Save an {@link Family} to the data store, either inserting or updating it.
     *
     * @param family the {@link Family} to save
     */
    void save(Family family);

    @Query("SELECT DISTINCT family FROM Family family left join fetch family.members")
    @Transactional(readOnly = true)
    Collection<Family> findAll();


}
