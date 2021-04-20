package warehouse.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.warehouse.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
