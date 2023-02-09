package info.changelogs.app.web.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import info.changelogs.app.dto.ProjectDTO;
import info.changelogs.app.dto.ProjectDetailedDTO;
import info.changelogs.app.dto.projection.ProjectMinimizedDTO;
import info.changelogs.app.service.ProjectServiceApi;
import info.changelogs.app.util.PaginationUtil;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "${application.api-path}/projects")
public class ProjectResource extends GenericResource<ProjectDTO, ProjectServiceApi> {

	public ProjectResource(ProjectServiceApi service) {
		super(service);
	}
	
	@GetMapping("minimized")
	public ResponseEntity<List<ProjectMinimizedDTO>> getUserProjectList(
			@Parameter(hidden = true) Pageable pageable, HttpServletRequest request) {
		// FIXME Get user from Security
		// https://github.com/GLinBoy/changelogs-backend/issues/22
		Page<ProjectMinimizedDTO> page = service.getAllNecessary("anonymouse", pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, request.getRequestURI());
		headers.setAccessControlExposeHeaders(Arrays.asList(HttpHeaders.LINK, "X-Total-Count"));
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<ProjectDetailedDTO> getProjectDetailByTitle(@PathVariable String title) {
		Optional<ProjectDetailedDTO> projectOPT = this.service.getProjectDetailByTitle(title);
		return projectOPT.map(ResponseEntity::ok)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
