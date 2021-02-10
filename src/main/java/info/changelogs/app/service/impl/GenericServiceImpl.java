package info.changelogs.app.service.impl;

import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import info.changelogs.app.dto.BaseDTO;
import info.changelogs.app.entity.BaseEntity;
import info.changelogs.app.service.GenericServiceApi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class GenericServiceImpl<T extends BaseDTO, E extends BaseEntity, S extends JpaRepository<E, Long>>
		implements GenericServiceApi<T> {

	protected final ResourceBundle messages = PropertyResourceBundle.getBundle("i18n/messages");

	protected final S repository;
	
	private final ModelMapper mapper;
	
	private Class<T> clazzT;
	private Class<E> clazzE;

	@Override
	@Transactional
	public T save(T t) {
		E e = mapper.map(t, clazzE);
		return mapper.map(repository.save(e), clazzT);
	}
	
	@Override
	@Transactional
	public List<T> saveAll(List<T> list) {
		List<E> collect = list.stream()
				.map(t -> mapper.map(t, clazzE)).collect(Collectors.toList());
		return repository.saveAll(collect).stream()
				.map(e -> mapper.map(e, clazzT)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public T update(T t) {
		return this.save(t);
	}

	@Override
	public T getSingleById(Long id) {
		E e = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				messages.getString("common.error.not.found").concat(id.toString())));
		return mapper.map(e, clazzT);
	}
	
	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public Page<T> getAll(Pageable pageable) {
		return repository.findAll(pageable)
				.map(e -> mapper.map(e, clazzT));
	}

	@Override
	@Transactional
	public void deleteSingleById(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteSingleByReference(T t) {
		this.deleteSingleById(t.getId());
	}

	@Override
	@Transactional
	public void deleteAll() {
		repository.deleteAll();
	}
}
