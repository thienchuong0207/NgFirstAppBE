package ng.first.app.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ng.first.app.be.constant.StudentConstant;
import ng.first.app.be.entity.StudentEntity;

/**
 * Student Repository
 * @author giraffefamily
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

	@Query(name = "getStudentsByClassId", value = StudentConstant.GET_STUDENTS_BY_CLASS_ID)
	public List<StudentEntity> getStudentsByClassId(@Param(value = "classId") String classId);
}
