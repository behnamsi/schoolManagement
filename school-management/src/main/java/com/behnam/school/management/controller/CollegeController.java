package com.behnam.school.management.controller;


import com.behnam.school.management.dto.CollegeDto;
import com.behnam.school.management.service.CollegeService;
import com.behnam.school.management.validation.annotations.college.UniqueCollegeName;
import com.behnam.school.management.validation.annotations.college.ValidCollegeId;
import com.behnam.school.management.validation.annotations.generic.ValidName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(path = "api/colleges")
@Validated
public class CollegeController {
    private final CollegeService service;


    @Autowired
    public CollegeController(CollegeService service) {
        this.service = service;
    }

    @GetMapping
    public List<CollegeDto> getAllColleges(
            @RequestParam(required = false) @Min(1) Integer page,
            @RequestParam(required = false) @Min(1) Integer limit
    ) {
        return service.getAllColleges(page, limit);
    }

    @PostMapping("")
    public void addCollege(@Valid @RequestBody CollegeDto collegeDto) {
        service.addCollege(collegeDto);
    }

    @DeleteMapping(path = "{collegeId}/delete-id")
    public void deleteCollegeByID(
            @PathVariable("collegeId") @ValidCollegeId Long collegeId) {
        service.deleteCollegeByID(collegeId);
    }
    //TODO ask to know about tow layer of validation

    @DeleteMapping(path = "{collegeName}")
    public void deleteCollegeByName(
            @PathVariable("collegeName") @ValidName String collegeName) {
        service.deleteCollegeByName(collegeName);
    }

    @PutMapping(path = "{collegeId}")
    public void updateCollege(
            @PathVariable("collegeId") @ValidCollegeId Long collegeId,
            @RequestParam(required = false) @UniqueCollegeName @ValidName String collegeName
    ) {
        service.updateCollege(collegeId, collegeName);
    }
}
