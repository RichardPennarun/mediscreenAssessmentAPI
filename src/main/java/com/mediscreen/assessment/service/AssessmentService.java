package com.mediscreen.assessment.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.mediscreen.assessment.constants.TriggerNumberByProfile;
import com.mediscreen.assessment.model.DTO.PatientDTO;
import com.mediscreen.assessment.util.Util;

@Service
public class AssessmentService {

	/*
	 * 
	 * Test du patient 
	 * INPUT : un PatientDTO avec liste de notes et de triggers
	 * OUTPUT : un Patient avec la variable assessment remplie
	 * 
	 * 
	 */
	public PatientDTO assess(PatientDTO patientToAssess) {

		// Récupération de la liste des triggers
		ArrayList<String> triggersList = patientToAssess.getTriggersList();
		
		// Comptage du nombre de déclencheurs dans les recommandations du patient
		int triggerNumber = Util.getTriggerNumber(patientToAssess, triggersList);

		// Récupération âge et sex du patient
		int age = Util.getAge(patientToAssess.getDob());
		String sex = patientToAssess.getSex();

		// Initialisation de la variable test
		String assessment = "TestNone";

		// Evaluation
		// Si le patient a plus de 30 ans
		if (age >= 30) {
			// Si le patient est un homme
			if (sex == "M") {
				// Si le nombres de déclencheurs est supérieur au seuil Early Onset
				if (triggerNumber >= TriggerNumberByProfile.M_ABOVE_THIRTY_EARLY_ONSET) {
					assessment = "TestEarlyOnset";
					// Si le nombres de déclencheurs est supérieur au seuil In Danger
				} else if (triggerNumber >= TriggerNumberByProfile.M_ABOVE_THIRTY_IN_DANGER
						&& triggerNumber < TriggerNumberByProfile.M_ABOVE_THIRTY_EARLY_ONSET) {
					assessment = "TestInDanger";
					// Si le nombres de déclencheurs est supérieur au seuil Borderline
				} else if (triggerNumber >= TriggerNumberByProfile.M_ABOVE_THIRTY_BORDERLINE
						&& triggerNumber < TriggerNumberByProfile.M_ABOVE_THIRTY_IN_DANGER) {
					assessment = "TestBorderline";
				}
				// Si le patient est une femme
			} else {
				// Si le nombres de déclencheurs est supérieur au seuil Early Onset
				if (triggerNumber >= TriggerNumberByProfile.W_ABOVE_THIRTY_EARLY_ONSET) {
					assessment = "TestEarlyOnset";
					// Si le nombres de déclencheurs est supérieur au seuil In Danger
				} else if (triggerNumber >= TriggerNumberByProfile.W_ABOVE_THIRTY_IN_DANGER
						&& triggerNumber < TriggerNumberByProfile.W_ABOVE_THIRTY_EARLY_ONSET) {
					assessment = "TestInDanger";
					// Si le nombres de déclencheurs est supérieur au seuil Borderline
				} else if (triggerNumber >= TriggerNumberByProfile.W_ABOVE_THIRTY_BORDERLINE
						&& triggerNumber < TriggerNumberByProfile.W_ABOVE_THIRTY_IN_DANGER) {
					assessment = "TestBorderline";
				}
			}
			// Si le patient a moins de 30 ans
		} else {
			// Si le patient est un homme
			if (sex == "M") {
				// Si le nombres de déclencheurs est supérieur au seuil Early Onset
				if (triggerNumber >= TriggerNumberByProfile.M_UNDER_THIRTY_EARLY_ONSET) {
					assessment = "TestEarlyOnset";
					// Si le nombres de déclencheurs est supérieur au seuil In Danger
				} else if (triggerNumber >= TriggerNumberByProfile.M_UNDER_THIRTY_IN_DANGER
						&& triggerNumber < TriggerNumberByProfile.M_UNDER_THIRTY_EARLY_ONSET) {
					assessment = "TestInDanger";
				}
				// Si le patient est une femme
			} else {
				// Si le nombres de déclencheurs est supérieur au seuil Early Onset
				if (triggerNumber >= TriggerNumberByProfile.W_UNDER_THIRTY_EARLY_ONSET) {
					assessment = "TestEarlyOnset";
					// Si le nombres de déclencheurs est supérieur au seuil In Danger
				} else if (triggerNumber >= TriggerNumberByProfile.W_UNDER_THIRTY_IN_DANGER
						&& triggerNumber < TriggerNumberByProfile.W_UNDER_THIRTY_EARLY_ONSET) {
					assessment = "TestInDanger";
				}
			}
		}

		patientToAssess.setAssessment(assessment);

		PatientDTO assessedPatient = new PatientDTO();

		assessedPatient.setLastName(patientToAssess.getLastName());
		assessedPatient.setFirstName(patientToAssess.getFirstName());
		assessedPatient.setDob(patientToAssess.getDob());
		assessedPatient.setSex(patientToAssess.getSex());
		assessedPatient.setNotes(patientToAssess.getNotes());
		assessedPatient.setAssessment(assessment);

		return assessedPatient;

	}

}