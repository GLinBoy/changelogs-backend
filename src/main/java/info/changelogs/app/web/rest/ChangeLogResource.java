package info.changelogs.app.web.rest;

import java.util.Arrays;
import java.util.List;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ChangeLogDTO;
import info.changelogs.app.dto.ChangeLogDetailedDTO;
import info.changelogs.app.service.ChangeLogServiceApi;
import info.changelogs.app.util.PaginationUtil;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "${application.api-path}/changelogs")
public class ChangeLogResource extends GenericResource<ChangeLogDTO, ChangeLogServiceApi> {

	public ChangeLogResource(ChangeLogServiceApi service) {
		super(service);
	}
	
	@GetMapping("latest")
	@PageableAsQueryParam
	public ResponseEntity<List<ChangeLogDetailedDTO>> getLatest(@Parameter(hidden = true) Pageable pageable, HttpServletRequest request) {
		Page<ChangeLogDetailedDTO> page = this.service.getLatest(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, request.getRequestURI());
		headers.setAccessControlExposeHeaders(Arrays.asList(HttpHeaders.LINK, "X-Total-Count"));
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	
	@GetMapping("/project/{project_title}")
	@PageableAsQueryParam
	public ResponseEntity<List<ChangeLogDTO>> getProjectChangeLog(@PathVariable("project_title") String projectTitle,
			@Parameter(hidden = true) Pageable pageable, HttpServletRequest request) {
		Page<ChangeLogDTO> page = this.service.getProjectChangeLog(projectTitle, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, request.getRequestURI());
		headers.setAccessControlExposeHeaders(Arrays.asList(HttpHeaders.LINK, "X-Total-Count"));
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	
	@GetMapping("/project/{project_title}/{version}")
	public ResponseEntity<List<ChangeLogDTO>> getProjectChangeLogVersion(
			@PathVariable("project_title") String projectTitle,
			@PathVariable String version, HttpServletRequest request) {
		List<ChangeLogDTO> list = this.service.getProjectChangeLogVersion(projectTitle, version);
		return ResponseEntity.ok(list);
	}

}
