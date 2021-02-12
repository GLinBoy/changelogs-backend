package info.changelogs.app.controller;

import java.net.URI;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import info.changelogs.app.dto.BaseDTO;
import info.changelogs.app.service.GenericServiceApi;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class GenericController<T extends BaseDTO, S extends GenericServiceApi<T>> {

	private final ResourceBundle messages = PropertyResourceBundle.getBundle("i18n/messages");

	protected final S service;

	@GetMapping
	@PageableAsQueryParam
	public ResponseEntity<Page<T>> getAll(@Parameter(hidden = true) Pageable pageable) {
		Page<T> page = service.getAll(pageable);
		return ResponseEntity.ok().body(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> getById(@PathVariable Long id) {
		T entity = service.getSingleById(id);
		return ResponseEntity.ok().body(entity);
	}

	@PostMapping
	public ResponseEntity<T> save(@Validated @RequestBody T entity, HttpServletRequest request) {
		T savedEntity = service.save(entity);
		String path = request.getRequestURI();
		URI location = URI.create(String.format("%s/%s", path, savedEntity.getId()));
		return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).body(savedEntity);
	}

	@PutMapping
	public ResponseEntity<T> update(@Validated @RequestBody T entity) {
		if (entity.getId() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, messages.getString("common.error.invalid.id"));
		}
		T updatedEntity = service.update(entity);
		return ResponseEntity.ok().body(updatedEntity);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteSingleById(id);
		return ResponseEntity.noContent().build();
	}

}