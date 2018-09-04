package ng.first.app.be.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ng.first.app.be.dto.ClassDTO;
import ng.first.app.be.entity.ClassEntity;
import ng.first.app.be.repository.ClassRepository;

/**
 * Class Service
 * @author giraffefamily
 *
 */
@Service
public class ClassService {

	@Autowired
	private ClassRepository classRepository;
	
	/**
	 * Get a class by ID
	 * @param classId
	 * @return CLass DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public ClassDTO getClassById(String classId) {
		ClassDTO dto = null;
		try {
			Optional<ClassEntity> optionalClassEntity = classRepository.findById(classId);
			ClassEntity entity = optionalClassEntity.isPresent() ? optionalClassEntity.get() : null;
			dto = entity != null ? convertEntityToDTO(entity) : null;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return dto;
	}
	
	/**
	 * Convert entity to DTO
	 * @param entity
	 * @return
	 */
	private ClassDTO convertEntityToDTO(ClassEntity entity) {
		ClassDTO dto = null;
		if (entity != null) {
			dto = new ClassDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setTeacherName(entity.getTeacherName());
		}
		return dto;
	}
}
