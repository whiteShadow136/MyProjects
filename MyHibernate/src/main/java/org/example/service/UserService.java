package org.example.service;

import org.example.entity.SysUser;

import java.util.concurrent.CompletableFuture;

/**
 * @Description:org.example.service
 * @Date:2024/1/30
 * @Author:谢锦创
 */
public interface UserService {

    SysUser getUser(String id);

    void asyncMethodA();

    void asyncMethodB();
}
