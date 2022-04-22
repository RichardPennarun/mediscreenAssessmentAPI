package com.mediscreen.assessment.model.DTO;

import java.util.ArrayList;

import com.mediscreen.assessment.model.Note;

public class PatientDTO {
	
private int id;
	
	private String lastName;
	
	private String firstName;
	
	private String dob;
	
	private String sex;
	
	private Iterable<Note> notes;
	
	private ArrayList<String> triggersList;
	
	private String assessment;
	
	public PatientDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAssessment() {
		return assessment;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}	


	public Iterable<Note> getNotes() {
		return notes;
	}
	
	public void setNotes(Iterable<Note> notes) {
		this.notes = notes;
	}

	public ArrayList<String> getTriggersList() {
		return triggersList;
	}

	public void setTriggersList(ArrayList<String> triggersList) {
		this.triggersList = triggersList;
	}
	

}
