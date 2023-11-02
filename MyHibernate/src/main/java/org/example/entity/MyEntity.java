package org.example.entity;

/**
 * @Description:org.example.entity
 * @Date:2023/11/3
 * @Author:谢锦创
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class MyEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    // getters, setters, etc.
}
