package com.mediscreen.assessment;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mediscreen.assessment.model.Note;
import com.mediscreen.assessment.model.DTO.PatientDTO;

@SpringBootTest
public class AssessmentModelTest {

	@Test
	public void getPatientTest() {

		PatientDTO p = new PatientDTO();
		p.setLastName("Pennarun");
		p.setFirstName("Adam");
		p.setDob("2014-12-24");
		p.setSex("M");
		p.setAssessment("TestNone");

		assertThat(p.getLastName()).isEqualTo("Pennarun");
		assertThat(p.getFirstName()).isEqualTo("Adam");
		assertThat(p.getDob()).isEqualTo("2014-12-24");
		assertThat(p.getSex()).isEqualTo("M");
		assertThat(p.getAssessment()).isEqualTo("TestNone");

	}

	@Test
	public void getNoteTest() {

		Note n = new Note();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		n.setId("625830e9850e1653bcfdb83d");
		n.setDate(timestamp);
		n.setPatientId(15);
		n.setRecommendation("ville, réaction");

		assertThat(n.getId()).isEqualTo("625830e9850e1653bcfdb83d");
		assertThat(n.getDate()).isEqualTo(timestamp);
		assertThat(n.getPatientId()).isEqualTo(15);
		assertThat(n.getRecommendation()).isEqualTo("ville, réaction");

	}

}
