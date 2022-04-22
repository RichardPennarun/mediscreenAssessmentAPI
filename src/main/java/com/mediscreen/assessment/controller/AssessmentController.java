package com.mediscreen.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen.assessment.model.DTO.PatientDTO;
import com.mediscreen.assessment.service.AssessmentService;

@RestController
public class AssessmentController {

	@Autowired
	private AssessmentService assessmentService;

	/**
	 * Create - Get patient assessment
	 * 
	 * @param a DTO patient A PatientDTO with its notes filled
	 * @return a DTO patient The PatientDTO wit its assessment filled
	 */
	@PostMapping("/getAssessment")
	public PatientDTO getAssessment(@RequestBody PatientDTO patientToAssess) throws Exception {

		PatientDTO assessedPatient = assessmentService.assess(patientToAssess);

		return assessedPatient;
	}

}
