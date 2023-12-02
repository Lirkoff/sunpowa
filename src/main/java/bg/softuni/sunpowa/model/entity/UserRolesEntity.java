package bg.softuni.sunpowa.model.entity;


import bg.softuni.sunpowa.model.enums.UserRoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;


    public Long getId() {
        return this.id;
    }

    public UserRolesEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public UserRoleEnum getRole() {
        return this.role;
    }

    public UserRolesEntity setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }
}
