package ng.first.app.be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ng.first.app.be.dto.StudentDTO;
import ng.first.app.be.entity.ClassEntity;
import ng.first.app.be.entity.StudentEntity;
import ng.first.app.be.enumeration.GenderEnum;
import ng.first.app.be.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private ClassService classService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * Get All Students
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<StudentEntity> getStudentsByClassId(String classId) {
		
		List<StudentEntity> students = null;
		try {
			students = studentRepository.getStudentsByClassId(classId);
		} catch(Exception ex) {
			students = null;
			ex.printStackTrace();
		}
		return students;
	}
	
	/**
	 * Add New Student
	 * @param studentDTO
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public StudentEntity addNewStudent(StudentEntity studentEntity) {
		
		StudentEntity savedStudentEntity = null;
		try {
			if (studentEntity != null) {
				savedStudentEntity = studentRepository.save(studentEntity);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return savedStudentEntity;
	}
	
	/**
	 * Delete Student by ID
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteStudentById(String id) {
		
		boolean isDeleted = false;
		try {
			if (studentRepository.findById(id).isPresent()) {
				studentRepository.deleteById(id);
			}
			isDeleted = true;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return isDeleted;
	}
	
	/**
	 * Convert Student DTO to Entity
	 * @param studentDTO
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public StudentEntity convertDTOtoEntity(StudentDTO studentDTO) {
		
		StudentEntity studentEntity = null;
		ClassEntity classEntity = classService.getClassById(studentDTO.getClassId());
		if (classEntity != null) {
			studentEntity = new StudentEntity();
			studentEntity.setId(studentDTO.getId());
			studentEntity.setName(studentDTO.getName());
			studentEntity.setPhoto(studentDTO.getPhoto());
			studentEntity.setGender(studentDTO.getGender().getValue());
			studentEntity.setStudentClass(classEntity);
		}
		return studentEntity;
	}
	
	/**
	 * Convert Student Entity to DTO
	 * @param studentEntity
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public StudentDTO convertEntityToDTO(StudentEntity studentEntity) {
		
		StudentDTO studentDTO = null;
		if (studentEntity != null) {
			studentDTO = new StudentDTO();
			studentDTO.setId(studentEntity.getId());
			studentDTO.setName(studentEntity.getName());
			studentDTO.setPhoto(studentEntity.getPhoto());
			studentDTO.setGender(studentEntity.getGender() == 0 ? GenderEnum.FEMALE : GenderEnum.MALE);
			studentDTO.setClassId(studentEntity.getStudentClass().getId());
		}
		return studentDTO;
	}
}
