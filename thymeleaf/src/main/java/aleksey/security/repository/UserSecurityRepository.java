package aleksey.security.repository;

import aleksey.security.model.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {

    void deleteByUsername(String username);

    Optional<UserSecurity> findByUsername(String username);
}
