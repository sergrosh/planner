package com.familyplanner.planner.family;

import java.util.Collection;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/family", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Family controller", tags = "family")
public class FamilyController {

    private final FamilyRepository familyRepository;

    public FamilyController(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    /**
     * Get all families {@link Family}.
     *
     * @return all families
     */
    @CrossOrigin
    @ApiOperation(value = "Get families by surname", tags = "Get families")
    @GetMapping(value = "/all")
    public Collection<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    /**
     * Get family {@link Family} by surname.
     *
     * @param surname surname
     * @return family
     */
    @CrossOrigin
    @ApiOperation(value = "Get families by surname", tags = "Get families")
    @GetMapping(value = "/{surname}")
    public ResponseEntity<Collection<Family>> getFamily(@PathVariable("surname") String surname) {
        Collection<Family> families = familyRepository.findByLastName(surname);
        if (families.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(families);
    }

}
