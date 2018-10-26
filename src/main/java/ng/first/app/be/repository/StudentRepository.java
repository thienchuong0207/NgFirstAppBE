package ng.first.app.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ng.first.app.be.constant.StudentConstant;
import ng.first.app.be.entity.StudentEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Student Repository
 * @author giraffefamily
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

	@Query(name = "getStudentsByClassId", value = StudentConstant.GET_STUDENTS_BY_CLASS_ID)
	public Page<StudentEntity> getStudentsByClassId(@Param(value = "classId") String classId, Pageable pageable);
}
