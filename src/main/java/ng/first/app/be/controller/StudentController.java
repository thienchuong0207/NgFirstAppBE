package ng.first.app.be.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ng.first.app.be.constant.StudentConstant;

/**
 * Student REST Controller 
 * @author giraffefamily
 *
 */
@RestController
@RequestMapping(path = StudentConstant.ROOT_PATH)
public class StudentController {

	@RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> hello() {
		return new ResponseEntity<String>("Student: Hello World!", HttpStatus.OK);
	}
}
