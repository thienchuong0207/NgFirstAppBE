package ng.first.app.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ng.first.app.be.entity.UserEntity;

/**
 * User Repository
 * @author giraffefamily
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {}
