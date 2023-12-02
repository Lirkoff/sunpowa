package bg.softuni.sunpowa.service;

import bg.softuni.sunpowa.model.dto.UserRegistrationDTO;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDTO);
}
