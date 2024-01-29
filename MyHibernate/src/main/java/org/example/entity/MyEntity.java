package org.example.entity;

/**
 * @Description:org.example.entity
 * @Date:2023/11/3
 * @Author:谢锦创
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import org.example.annotation.DynamicEnumCheck;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
//@DynamicEnumCheck
public class MyEntity extends BasicObject {
//    @Id
//    private String id;

//    @Nullable
//    @Column(length = 255)
//    private String name;
    // getters, setters, etc.

    @Nullable
    @Column
//    @DynamicEnumCheck
    String dyEnum;

    @Nullable
    @Type(type = "org.example.hibernateType.MulColumnType")
    @Column(columnDefinition = "Varchar(255)")
    JSONArray mulReference;

    @Nullable
    @Column(columnDefinition = "json")
    public String testName;
}
