package bg.softuni.sunpowa.repository;

import bg.softuni.sunpowa.model.entity.UserEntity;
import bg.softuni.sunpowa.model.entity.UserRolesEntity;
import bg.softuni.sunpowa.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Long> {
    UserRolesEntity getByRole(UserRoleEnum userRoleEnum);

}

