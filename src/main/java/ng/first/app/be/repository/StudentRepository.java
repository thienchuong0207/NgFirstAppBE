package ng.first.app.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ng.first.app.be.entity.StudentEntity;

/**
 * Student Repository
 * @author giraffefamily
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

}
