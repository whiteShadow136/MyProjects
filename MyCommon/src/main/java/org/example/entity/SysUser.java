package org.example.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Description:org.example.entity
 * @Date:2023/11/21
 * @Author:谢锦创
 */
@Data
//@Builder
@Entity
public class SysUser {
    @Id
    String id;

    String userName;

    int age;
}
