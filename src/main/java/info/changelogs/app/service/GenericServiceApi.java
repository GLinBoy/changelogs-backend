package info.changelogs.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericServiceApi<T> {
	T save(T t);
	
	List<T> saveAll(List<T> t);

	T update(T t);

	T getSingleById(Long id);
	
	Long count();

	Page<T> getAll(Pageable pageable);

	void deleteSingleById(Long id);

	void deleteSingleByReference(T t);

	void deleteAll();
}
