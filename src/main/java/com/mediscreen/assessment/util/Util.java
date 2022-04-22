package com.mediscreen.assessment.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mediscreen.assessment.model.Note;
import com.mediscreen.assessment.model.DTO.PatientDTO;

public class Util {

	/*
	 * Calcul de l'âge à partir d'une date de naissance 
	 * INPUT : un String, la date,
	 * quelque soit son format 
	 * OUTPUT : un int l'âge
	 */
	public static int getAge(final String dob) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localBirthdate = LocalDate.parse(dob, formatter);
		LocalDate today = LocalDate.now();
		Period age = Period.between(localBirthdate, today);

		return age.getYears();
	}

	/*
	 * Vérification de la présence des déclencheurs dans les notes du patient 
	 * INPUT : Un PatientDTO et la liste des déclencheurs 
	 * OUTPUT : Le nombre de déclencheurs
	 * présents dans les notes
	 */
	public static int getTriggerNumber(PatientDTO patientDTO, ArrayList<String> triggersList) {

		// Concaténation de l'ensemble des recommandations du patient
		String recommendations = "";
		for (Note note : patientDTO.getNotes()) {
			recommendations = recommendations + " " + note.getRecommendation() + " ";
		}

		// Initialisation de la variable Nombre de triggers
		int triggerNumber = 0;

		// Pour chaque trigger, vérification de la présence d'au moins
		// une occurence dans les recommandations
		for (String trigger : triggersList) {

			Pattern pattern = Pattern.compile("(?i).*" + trigger);
			Matcher matcher = pattern.matcher(recommendations);
			if (matcher.find() == true) {
				triggerNumber++;
			}
		}

		return triggerNumber;
	}

}
