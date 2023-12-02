package bg.softuni.sunpowa.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{
        @Column
        private String email;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private List<UserRolesEntity> roles;

        @Column
        private String password;

        @Column
        private String firstName;

        @Column
        private String lastName;

        @Column
        private boolean active;

        public String getEmail() {
                return this.email;
        }

        public UserEntity setEmail(String email) {
                this.email = email;
                return this;
        }

        public List<UserRolesEntity> getRoles() {
                return this.roles;
        }

        public UserEntity setRoles(List<UserRolesEntity> roles) {
                this.roles = roles;
                return this;
        }

        public String getPassword() {
                return this.password;
        }

        public UserEntity setPassword(String password) {
                this.password = password;
                return this;
        }

        public String getFirstName() {
                return this.firstName;
        }

        public UserEntity setFirstName(String firstName) {
                this.firstName = firstName;
                return this;
        }

        public String getLastName() {
                return this.lastName;
        }

        public UserEntity setLastName(String lastName) {
                this.lastName = lastName;
                return this;
        }

        public boolean isActive() {
                return this.active;
        }

        public UserEntity setActive(boolean active) {
                this.active = active;
                return this;
        }



}
