package com.mediscreen.assessment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.assessment.controller.AssessmentController;
import com.mediscreen.assessment.model.DTO.PatientDTO;
import com.mediscreen.assessment.service.AssessmentService;

@WebMvcTest(controllers = AssessmentController.class)
public class AssessmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	

	@MockBean
	private AssessmentService assessmentService;


	@Test
	public void testGetAssessment() throws Exception {
		mockMvc.perform(post("/getAssessment")
				.content(asJsonString(new PatientDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
}
