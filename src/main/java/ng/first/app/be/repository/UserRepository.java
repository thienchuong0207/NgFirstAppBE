package ng.first.app.be.repository;

import ng.first.app.be.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User Repository
 * @author giraffefamily
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {

    public List<UserEntity> findByUsernameAndPassword(String username, String password);
}
