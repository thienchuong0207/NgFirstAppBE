package ng.first.app.be.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import ng.first.app.be.enumeration.GenderEnum;

/**
 * Student DTO
 * @author giraffefamily
 *
 */
@JsonInclude(value = Include.ALWAYS)
public class StudentDTO {

	/* Properties */ 
	@JsonProperty(value = "id", required = true)
	private String id;
	@JsonProperty(value = "name", required = true)
	private String name;
	@JsonProperty(value = "gender", required = true)
	private GenderEnum gender;
	@JsonProperty(value = "photo", required = true)
	private byte[] photo;
	@JsonProperty(value = "classId", required = true)
	private String classId;
		
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
	
	public GenderEnum getGender() {
		return this.gender;
	}
	
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}
	
	public byte[] getPhoto() {
		return this.photo;
	}
	
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public String getClassId() {
		return this.classId;
	}
	
	public void setClassId(String classId) {
		this.classId = classId;
	}
}
