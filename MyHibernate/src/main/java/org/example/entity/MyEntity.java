package org.example.entity;

/**
 * @Description:org.example.entity
 * @Date:2023/11/3
 * @Author:谢锦创
 */

import lombok.Data;
import org.example.annotation.DynamicEnumCheck;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@DynamicEnumCheck
public class MyEntity extends PersistObject {
    @Id
    @GeneratedValue
    private String id;

    @Column(length = 255)
    private String name;
    // getters, setters, etc.

    String dyEnum;
}
