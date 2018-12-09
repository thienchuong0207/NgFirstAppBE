package ng.first.app.be.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class Entity
 * @author giraffefamily
 *
 */
@Entity
@Table(name = "CLASSES")
public class ClassEntity {

	/* Properties */
	@Id
	@Column(name = "ID", nullable = false)
	private String id;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "TEACHER_NAME", nullable = false)
	private String teacherName;
	@OneToMany(mappedBy = "studentClass", fetch = FetchType.EAGER)
	private List<StudentEntity> students;
	
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
	
	public List<StudentEntity> getStudents() {
		return this.students;
	}
	
	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
}