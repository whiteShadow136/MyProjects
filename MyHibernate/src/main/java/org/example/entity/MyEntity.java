package org.example.entity;

/**
 * @Description:org.example.entity
 * @Date:2023/11/3
 * @Author:谢锦创
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.example.annotation.DynamicEnumCheck;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DynamicEnumCheck
public class MyEntity extends BasicObject {
//    @Id
//    private String id;

//    @Nullable//    @Column(length = 255)
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

    public static MyEntity getRandomInstance() {
        MyEntity myEntity = new MyEntity();
        myEntity.setId(UUID.randomUUID().toString().replace("-", ""));
        myEntity.setDyEnum("A");
        myEntity.setRdmExtensionType("DyEnumExt");
        myEntity.setNameEn("DyEnum");
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("clazz", MyEntity.class);
        jsonArray.add(jsonObject);
        myEntity.setMulReference(jsonArray);
        JSONArray jsonArrayTest = new JSONArray();
        JSONObject jsonObjectTest = new JSONObject();
        jsonObjectTest.put("id", 1);
        jsonObjectTest.put("name", 2);
        jsonArrayTest.add(jsonObjectTest);
        myEntity.setJsonArrayTest(jsonArrayTest);
        myEntity.setCreateTime(LocalDateTime.now());
        myEntity.setLastUpdateTime(LocalDateTime.now());
        return myEntity;
    }

}
