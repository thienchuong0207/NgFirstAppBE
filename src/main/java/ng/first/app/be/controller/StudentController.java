package ng.first.app.be.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ng.first.app.be.constant.StudentConstant;
import ng.first.app.be.dto.StudentDTO;
import ng.first.app.be.dto.StudentPageDTO;
import ng.first.app.be.entity.StudentEntity;
import ng.first.app.be.service.StudentService;

/**
 * Student REST Controller 
 * @author giraffefamily
 *
 */
@RestController
@RequestMapping(path = StudentConstant.ROOT_PATH)
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/**
	 * Get All Students
	 * @return
	 */
	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStudentsByClassId(@RequestParam(value = "classId", required = true) String classId, Pageable pageable) {
		Page<StudentEntity> studentEntitiesPage = studentService.getStudentsByClassId(classId, pageable);
		if (studentEntitiesPage == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (studentEntitiesPage.getContent().isEmpty()) {
			return new ResponseEntity<List<StudentDTO>>(new ArrayList<StudentDTO>(), HttpStatus.NO_CONTENT);
		} else {
			List<StudentEntity> studentEntities = studentEntitiesPage.getContent();
			List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();
			studentEntities.stream().forEach((studentEntity) -> {
				studentDTOs.add(studentService.convertEntityToDTO(studentEntity));
			});
			StudentPageDTO studentPageDTO = new StudentPageDTO();
			studentPageDTO.setTotal(studentEntitiesPage.getTotalElements());
			studentPageDTO.setTotalPages(studentEntitiesPage.getTotalPages());
			studentPageDTO.setSize(studentEntitiesPage.getSize());
			studentPageDTO.setStudents(studentDTOs);
			return new ResponseEntity<StudentPageDTO>(studentPageDTO, HttpStatus.OK);
		}
	}
	
	/**
	 * Add New Student
	 * @param studentDTO
	 * @return
	 */
	@RequestMapping(path = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addNewStudent(@RequestBody StudentDTO studentDTO) {
		StudentEntity studentEntity = studentService.convertDTOtoEntity(studentDTO);
		if (studentEntity != null) {
			StudentEntity savedStudentEntity = studentService.addNewStudent(studentEntity);
			if (savedStudentEntity != null) {
				return new ResponseEntity<StudentDTO>(studentService.convertEntityToDTO(savedStudentEntity), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Delete Student by ID
	 * @param studentId
	 * @return
	 */
	@RequestMapping(path = "/{studentId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStudentById(@PathVariable(value = "studentId") String studentId) {
		boolean isDeleted = studentService.deleteStudentById(studentId);
		if (isDeleted) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
