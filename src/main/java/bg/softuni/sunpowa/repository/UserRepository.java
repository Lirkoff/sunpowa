package bg.softuni.sunpowa.repository;

import bg.softuni.sunpowa.model.entity.UserEntity;
import bg.softuni.sunpowa.model.entity.UserRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);


}
