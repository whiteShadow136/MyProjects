package springsecuritymvcinspect.service;


import springsecuritymvcinspect.model.User;

public interface UserService {
    User getUserByName(String userName);
}
