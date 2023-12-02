package bg.softuni.sunpowa.repository;

import bg.softuni.sunpowa.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
