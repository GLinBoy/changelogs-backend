package info.changelogs.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletResponse;

import info.changelogs.app.web.controller.HomeController;

@ExtendWith(MockitoExtension.class)
class HomeControllerUnitTest {

	@InjectMocks
	private HomeController homeController;

	@Mock
	private MockHttpServletResponse response;

	@BeforeEach
	void setup() throws IllegalAccessException {
		homeController = new HomeController();
	}

	@Test
	void contextLoads() {
		assertThat(homeController).isNotNull();
	}

	@Test
	void testRedirect() throws IOException {
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

		homeController.redirect(response);
		verify(response).sendRedirect(captor.capture());
		assertEquals("/swagger-ui.html", captor.getValue());
	}

}
