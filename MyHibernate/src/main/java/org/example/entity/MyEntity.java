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

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DynamicEnumCheck
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
    @Type(type = "org.example.hibernateType.JsonType")
    @Column(columnDefinition = "Varchar(255)")
    JSONArray mulReference;

    @Nullable
    @Type(type = "org.example.hibernateType.JsonArrayType")
    @Column(columnDefinition = "Varchar(255)")
    JSONArray JsonArrayTest;

    @Nullable
    @Column(columnDefinition = "json")
    public String testName;

//    @ValidGender
//    public String getGenderFieldForValidation() {
//        // 你可以在这里访问整个实体的状态
//        // ...
//        return gender;
//    }


}
