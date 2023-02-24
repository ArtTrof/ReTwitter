package web.project.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.project.app.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);

}
