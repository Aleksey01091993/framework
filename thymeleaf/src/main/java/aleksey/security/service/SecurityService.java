package aleksey.security.service;

import aleksey.security.model.UserSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface SecurityService extends UserDetailsService {

    void createUser(UserSecurity user);

    void updateUser(UserSecurity user);

    void deleteUser(String username);

    void changePassword(String oldPassword, String newPassword);

    boolean userExists(String username);


}
