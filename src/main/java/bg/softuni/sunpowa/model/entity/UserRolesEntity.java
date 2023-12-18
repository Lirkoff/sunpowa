package bg.softuni.sunpowa.model.entity;


import bg.softuni.sunpowa.model.enums.UserRoleEnum;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "roles")
public class UserRolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;





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

    public Set<UserEntity> getUsers() {
        return this.users;
    }

    public UserRolesEntity setUsers(Set<UserEntity> users) {
        this.users = users;
        return this;
    }
}
