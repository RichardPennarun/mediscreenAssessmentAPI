package com.mediscreen.assessment;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mediscreen.assessment.model.Note;
import com.mediscreen.assessment.model.DTO.PatientDTO;
import com.mediscreen.assessment.service.AssessmentService;

@SpringBootTest
public class AssessmentServiceTest {
	
	@Autowired
	AssessmentService assessmentService;

	// Man under 30
	
	@Test
	public void Under30Man0Trigger() {
		Note note1 = new Note(25, "patient, hémoglobine A1C");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestNone"));
	}
	
	@Test
	public void Under30Man1TriggerShouldGetTestNone() {
		Note note1 = new Note(25, "patient, hémoglobine A1C");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestNone"));
	}

	@Test
	public void Under30Man2TriggersShouldGetTestBorderline() {
		Note note1 = new Note(25, "patient");
		Note note2 = new Note(25, "ville, cholestérol, taille");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestNone"));
	}

	@Test
	public void Under30Man3Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestInDanger"));
	}

	@Test
	public void Under30Man4Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestInDanger"));
	}

	@Test
	public void Under30Man5Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol, taille");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestEarlyOnset"));
	}

	@Test
	public void Under30Man6Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestEarlyOnset"));
	}


	// Woman under 30
	
	@Test
	public void Under30Woman0Trigger() {
		Note note1 = new Note(25, "patient");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestNone"));
	}
	
	@Test
	public void Under30Woman1Triggere() {
		Note note1 = new Note(25, "patient, hémoglobine A1C");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestNone"));
	}

	@Test
	public void Under30Woman2Triggers() {
		Note note1 = new Note(25, "patient");
		Note note2 = new Note(25, "ville, cholestérol, taille");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestNone"));
	}

	@Test
	public void Under30Woman3Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestNone"));
	}

	@Test
	public void Under30Woman4Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestInDanger"));
	}

	@Test
	public void Under30Woman5Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol, taille");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestInDanger"));
	}

	@Test
	public void Under30Woman6Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestInDanger"));
	}

	@Test
	public void Under30Woman7Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids, vertige");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestEarlyOnset"));
	}

	@Test
	public void Under30Woman8Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction, anticorps");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids, vertige");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("2005-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestEarlyOnset"));
	}

	



	// Woman above 30
	
	@Test
	public void Above30Woman0Trigger() {
		Note note1 = new Note(25, "patient");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestNone"));
	}
	
	@Test
	public void Above30Woman1Trigger() {
		Note note1 = new Note(25, "patient, hémoglobine A1C");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestNone"));
	}

	@Test
	public void Above30Woman2Triggers() {
		Note note1 = new Note(25, "patient");
		Note note2 = new Note(25, "ville, cholestérol, taille");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestBorderline"));
	}

	@Test
	public void Above30Woman3Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestBorderline"));
	}

	@Test
	public void Above30Woman4Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestBorderline"));
	}

	@Test
	public void Above30Woman5Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol, taille");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestBorderline"));
	}

	@Test
	public void Above30Woman6Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestInDanger"));
	}

	@Test
	public void Above30Woman7Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids, vertige");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestInDanger"));
	}

	@Test
	public void Above30Woman8Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction, anticorps");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids, vertige");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestEarlyOnset"));
	}

	@Test
	public void Above30Woman9Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction, anticorps");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids, vertige, rechute");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("F");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestEarlyOnset"));
	}



	// Man above 30
	
	@Test
	public void Above30Man0Trigger() {
		Note note1 = new Note(25, "patient");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestNone"));
	}
	
	@Test
	public void Above30Man1Trigger() {
		Note note1 = new Note(25, "patient, hémoglobine A1C");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestNone"));
	}

	@Test
	public void Above30Man2Triggerse() {
		Note note1 = new Note(25, "patient");
		Note note2 = new Note(25, "ville, cholestérol, taille");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestBorderline"));
	}

	@Test
	public void Above30Man3Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestBorderline"));
	}

	@Test
	public void Above30Man4Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestBorderline"));
	}

	@Test
	public void Above30Man5Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol, taille");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestBorderline"));
	}

	@Test
	public void Above30Man6Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestInDanger"));
	}

	@Test
	public void Above30Man7Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids, vertige");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestInDanger"));
	}

	@Test
	public void Above30Man8Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction, anticorps");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids, vertige");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestEarlyOnset"));
	}

	@Test
	public void Above30Man9Triggers() {
		Note note1 = new Note(25, "patient, hémoglobine A1C, fumeur, réaction, anticorps");
		Note note2 = new Note(25, "ville, cholestérol, taille, poids, vertige, rechute");
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note1);
		notes.add(note2);
		ArrayList<String> triggers = new ArrayList<String>();
		triggers.add("Hémoglobine A1C");
		triggers.add("Microalbumine");
		triggers.add("Taille");
		triggers.add("Poids");
		triggers.add("Fume");
		triggers.add("Anorma");
		triggers.add("Cholestérol");
		triggers.add("Vertige");
		triggers.add("Rechute");
		triggers.add("Réaction");
		triggers.add("Anticorps");
		PatientDTO p = new PatientDTO();
		p.setId(25);
		p.setLastName("Melies");
		p.setFirstName("Elia");
		p.setDob("1905-12-31");
		p.setSex("M");
		p.setNotes(notes);
		p.setTriggersList(triggers);
		PatientDTO testedPatient = assessmentService.assess(p);
		assertThat(testedPatient.getAssessment().equalsIgnoreCase("TestEarlyOnset"));
	}
	
}
