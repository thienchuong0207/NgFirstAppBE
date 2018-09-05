package ng.first.app.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Student Entity
 * @author giraffefamily
 *
 */
@Entity
@Table(name = "STUDENTS")
public class StudentEntity {

	/* Properties */
	@Id
	@Column(name = "ID", nullable = false)
	private String id;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "GENDER", nullable = false)
	private Integer gender;
	@Column(name = "PHOTO", nullable = true)
	private byte[] photo;
	@ManyToOne
	@JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
	private ClassEntity studentClass;
	
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
	
	public Integer getGender() {
		return this.gender;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public byte[] getPhoto() {
		return this.photo;
	}
	
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public ClassEntity getStudentClass() {
		return this.studentClass;
	}
	
	public void setStudentClass(ClassEntity studentClass) {
		this.studentClass = studentClass;
	}
}
