package ng.first.app.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ng.first.app.be.entity.ClassEntity;

/**
 * Class Repository
 * @author giraffefamily
 *
 */
@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, String> {

}
