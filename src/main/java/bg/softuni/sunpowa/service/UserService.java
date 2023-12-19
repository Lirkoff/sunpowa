package bg.softuni.sunpowa.service;

import bg.softuni.sunpowa.model.dto.UserRegistrationDTO;


public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDTO);

    void addUserRole(String email);
    void removeUserRole(String email);

    void editProfile(String oldEmail, String newEmail);
}
