package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.zalando.problem.jackson.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.controller.OrganizationController;
import info.changelogs.app.dto.OrganizationDTO;

@ChangeLogIntegrationTest
class GenericControllerIntegrationTest {

	@Autowired
	private OrganizationController organizationController;

	@Autowired
	private MockMvc mockMvc;

	@Value("${application.api-path}/organization")
	private String baseUrl;
	private final Long getId  = 1001L;
	private final Long deleteId  = 1025L;
	
	@Test
	void contextLoads() {
		assertThat(organizationController).isNotNull();
	}

	@Test
	void testGetAll() throws Exception {
		this.mockMvc.perform(get(baseUrl))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.*", hasSize(20)))
			.andExpect(jsonPath("$.*.id").isNotEmpty());
	}

	@Test
	void testGetById() throws Exception {
		this.mockMvc.perform(get(baseUrl + "/{id}", getId))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.id").value(getId));
	}

	@Test
	void testSave() throws Exception {
		this.mockMvc.perform(post(baseUrl)
			.content(asJsonString(OrganizationDTO.builder()
					.name("ITEST NAME")
					.title("ITEST TITLE")
					.slogan("ITEST SLOGAN")
					.website("https://itest-website.com")
					.email("info@itest-website.com")
					.location("ITEST LOCATION")
					.logo(null)
					.verified(Boolean.TRUE)
					.build()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.id").exists())
			.andExpect(jsonPath("$.isActive").value(Boolean.TRUE));
	}
	
	public static String asJsonString(final Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper = mapper.findAndRegisterModules();

			// Registered Problem Module
			mapper.registerModules(new ProblemModule(), new ConstraintViolationProblemModule());
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	void testUpdate() throws Exception {
		this.mockMvc.perform(put(baseUrl)
				.content(asJsonString(OrganizationDTO.builder()
						.id(getId)
						.name("ITEST UPDATE NAME")
						.title("ITEST TITLE")
						.slogan("ITEST SLOGAN")
						.website("https://itest-website.com")
						.email("info@itest-website.com")
						.location("ITEST LOCATION")
						.verified(Boolean.TRUE)
						.isActive(Boolean.TRUE)
						.createdBy("rwoodworth0")
						.editedBy("bolennane0")
						.createdOn(Instant.ofEpochSecond(1611560243))
						.editedOn(Instant.ofEpochSecond(1590520987))
						.version(12)
						.build()))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(getId))
				.andExpect(jsonPath("$.name").value("ITEST UPDATE NAME"))
				.andExpect(jsonPath("$.title").value("ITEST TITLE"))
				.andExpect(jsonPath("$.slogan").value("ITEST SLOGAN"))
				.andExpect(jsonPath("$.website").value("https://itest-website.com"))
				.andExpect(jsonPath("$.email").value("info@itest-website.com"))
				.andExpect(jsonPath("$.verified").value(Boolean.TRUE))
				.andExpect(jsonPath("$.isActive").value(Boolean.TRUE));
	}

	@Test
	void testDeleteById() throws Exception {
		this.mockMvc.perform(delete(baseUrl + "/{id}", deleteId))
		.andDo(print())
		.andExpect(status().isNoContent());
		
		this.mockMvc.perform(get(baseUrl + "/{id}", deleteId))
		.andDo(print())
		.andExpect(status().isNotFound());
	}

}
