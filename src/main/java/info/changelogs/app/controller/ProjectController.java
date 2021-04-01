package info.changelogs.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ProjectDTO;
import info.changelogs.app.dto.projection.ProjectMinimizedDTO;
import info.changelogs.app.service.ProjectServiceApi;
import info.changelogs.app.util.PaginationUtil;

@RestController
@RequestMapping(path = "project")
public class ProjectController extends GenericController<ProjectDTO, ProjectServiceApi> {

	public ProjectController(ProjectServiceApi service) {
		super(service);
	}
	
	@GetMapping("minimized")
	public ResponseEntity<List<ProjectMinimizedDTO>> getUserProjectList(Pageable pageable, HttpServletRequest request) {
		// FIXME Get user from Security
		// https://github.com/GLinBoy/changelogs-backend/issues/22
		Page<ProjectMinimizedDTO> page = service.getAllNecessary("anonymouse", pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, request.getRequestURI());
		headers.setAccessControlExposeHeaders(Arrays.asList(HttpHeaders.LINK, "X-Total-Count"));
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

}
