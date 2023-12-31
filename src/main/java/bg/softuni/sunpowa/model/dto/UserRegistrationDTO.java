package bg.softuni.sunpowa.model.dto;

import bg.softuni.sunpowa.model.validation.FieldMatch;
import bg.softuni.sunpowa.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords must be identical"
)
public record UserRegistrationDTO(@NotEmpty String firstName,
                                  @NotEmpty String lastName,
                                  @NotNull @Email @UniqueUserEmail String email,
                                  String password,
                                  String confirmPassword) {


    public String fullName() {
        return firstName + " " + lastName;
    }

    public static UserRegistrationDTO empty() {
        return new UserRegistrationDTO(null,null,null,null,null);
    }
}