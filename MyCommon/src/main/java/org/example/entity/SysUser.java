package org.example.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @Description:org.example.entity
 * @Date:2023/11/21
 * @Author:谢锦创
 */
@Data
@Builder
public class SysUser {
    String id;

    String userName;
}
