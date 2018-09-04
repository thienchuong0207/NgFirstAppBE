package ng.first.app.be.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Class DTO
 * @author giraffefamily
 *
 */
@JsonInclude(value = Include.ALWAYS)
public class ClassDTO {

	/* Properties */
	@JsonProperty(value = "id", required = true)
	private String id;
	@JsonProperty(value = "name", required = true)
	private String name;
	@JsonProperty(value = "teacherName", required = true)
	private String teacherName;
	
	/* Getters and Setters */
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTeacherName() {
		return this.teacherName;
	}
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}
