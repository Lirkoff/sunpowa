package bg.softuni.sunpowa.repository;

import bg.softuni.sunpowa.model.entity.UserRolesEntity;
import bg.softuni.sunpowa.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Long> {
    UserRolesEntity getByRole(UserRoleEnum userRoleEnum);
}

