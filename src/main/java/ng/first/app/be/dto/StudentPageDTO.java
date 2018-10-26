package ng.first.app.be.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This DTO is used to contain a list of Student DTOs
 * and pagination-related information
 * @author giraffefamily
 *
 */
@JsonInclude(value = Include.ALWAYS)
public class StudentPageDTO implements java.io.Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -2802928546662084900L;
	
	/* Properties */
	/* Number of Students in Total */
	@JsonProperty(value = "total")
	private long total;
	/* Number of Pages in Total */
	@JsonProperty(value = "totalPages")
	private int totalPages;
	/* Number of Students per Page */
	@JsonProperty(value = "size")
	private int size;
	/* List of Students based on Selected Page */
	@JsonProperty(value = "students")
	private List<StudentDTO> students = null;
	
	/* Getters and Setters */
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<StudentDTO> getStudents() {
		return students;
	}
	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}
}
