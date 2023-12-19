package bg.softuni.sunpowa.model.dto;

import bg.softuni.sunpowa.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserChangeProfileDTO(@Email String oldEmail,
                                   @Email @UniqueUserEmail String newEmail) {
}
