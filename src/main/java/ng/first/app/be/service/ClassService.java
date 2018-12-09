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
	public ClassEntity getClassById(String classId) {
		ClassEntity entity = null;
		try {
			Optional<ClassEntity> optionalClassEntity = classRepository.findById(classId);
			entity = optionalClassEntity.isPresent() ? optionalClassEntity.get() : null;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return entity;
	}
	
	/**
	 * Convert entity to DTO
	 * @param entity
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public ClassDTO convertEntityToDTO(ClassEntity classEntity) {
		ClassDTO classDTO = null;
		if (classEntity != null) {
			classDTO = new ClassDTO();
			classDTO.setId(classEntity.getId());
			classDTO.setName(classEntity.getName());
			classDTO.setTeacherName(classEntity.getTeacherName());
		}
		return classDTO;
	}
}
