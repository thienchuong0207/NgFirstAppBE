package ng.first.app.be.service;

import ng.first.app.be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User Service
 * @author giraffefamily
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Authenticate User
     * @param username
     * @param password
     * @return
     */
    public boolean authenticate(String username, String password) {
        boolean isValid = false;

        return isValid;
    }

}
