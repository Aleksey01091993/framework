package aleksey.security.service;

import aleksey.security.model.UserSecurity;
import aleksey.security.repository.UserSecurityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserSecurityRepository repository;


    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public void createUser(UserSecurity user) {
        repository.save(user);
    }

    @Override
    public void updateUser(UserSecurity user) {
        repository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        repository.deleteByUsername(username);
    }

    @Override
    public boolean userExists(String username) {
        return repository.findByUsername(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
