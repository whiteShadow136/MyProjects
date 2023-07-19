package springsecuritymvcinspect.service.impl;


import cn.hutool.core.collection.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springsecuritymvcinspect.model.Role;
import springsecuritymvcinspect.model.User;
import springsecuritymvcinspect.model.enumerate.RoleType;
import springsecuritymvcinspect.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User getUserByName(String userName) {
        if (!"root".equals(userName)) {
            throw new RuntimeException("用户不存在");
        }

//        List<Role> roles = List.of(new Role(RoleType.ADMIN), new Role(RoleType.USER));
//        List<Role> roles = List.of( new Role(RoleType.USER));
        List<Role> roles = ListUtil.of( new Role(RoleType.USER));

        return new User(userName, passwordEncoder.encode("qq"), roles);
    }
}
