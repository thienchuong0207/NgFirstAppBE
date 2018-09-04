package ng.first.app.be.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import ng.first.app.be.constant.ClassConstant;
import ng.first.app.be.dto.ClassDTO;
import ng.first.app.be.service.ClassService;

/**
 * Class Controller
 * @author giraffefamily
 *
 */
@RestController
@RequestMapping(path = ClassConstant.ROOT_PATH)
public class ClassController {

	@Autowired
	private ClassService classService;
	
	@RequestMapping(path = "/{classId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getClassById(@PathVariable(value = "classId") String classId) {
		ClassDTO dto = classService.getClassById(classId);
		if (dto != null) {
			return new ResponseEntity<ClassDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
