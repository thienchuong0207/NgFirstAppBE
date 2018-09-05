package ng.first.app.be.constant;

public class StudentConstant {

	/* Paths */
	public static final String ROOT_PATH = "/student";
	
	/* JPA QUERIES */
	public static final String GET_STUDENTS_BY_CLASS_ID = "SELECT s FROM StudentEntity s WHERE s.studentClass.id = :classId";
}
