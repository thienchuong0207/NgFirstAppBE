package ng.first.app.be.service;

import ng.first.app.be.entity.UserEntity;
import ng.first.app.be.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User Service
 * @author giraffefamily
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(AuthService.class);

    /**
     * Authenticate User
     * @param username
     * @param password
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean authenticate(String username, String password) {
        boolean isValid = false;
        try {
            List<UserEntity> users = userRepository.findByUsernameAndPassword(username, password);
            if (users != null && users.size() == 1) {
                isValid = true;
            }
        } catch(Exception ex) {
            logger.error("Error in AuthService.authenticate()", ex);
        }
        return isValid;
    }
}
