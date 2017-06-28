package fr.insee.bar.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccueilControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void welcome() throws Exception {
		mockMvc
			.perform(get("/"))
			.andExpect(status().is(HttpStatus.MOVED_PERMANENTLY.value()))
			.andExpect(model().attributeDoesNotExist("message"));
	}

	@Test
	public void hello() throws Exception {
		mockMvc
			.perform(get("/accueil"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("message"))
			.andExpect(view().name("accueil"))
			.andExpect(forwardedUrl("/WEB-INF/views/accueil.jsp"));
	}
}