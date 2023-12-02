package bg.softuni.sunpowa.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserRegistrationDTO(@NotEmpty String firstName,
                                  @NotEmpty String lastName,
                                  @NotNull @Email String email,
                                  String password,
                                  String confirmPassword) {


    public String fullName() {
        return firstName + " " + lastName;
    }
}
