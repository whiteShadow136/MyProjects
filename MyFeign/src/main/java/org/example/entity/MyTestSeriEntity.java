package org.example.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Description:org.example.entity
 * @Date:2024/10/15
 * @Author:谢锦创
 */
@Data
public class MyTestSeriEntity {

    private AAA name;

    private Integer age;

    public AAA getName() {
        return name;
    }

    public void setName(AAA name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    @JsonCreator
//    public MyTestSeriEntity(@JsonProperty("name") AAA name, @JsonProperty("age") Integer age) {
//        this.name = name;
//        this.age = age;
//    }

//    @JsonCreator
//    public MyTestSeriEntity(@JsonProperty("name")AAA name) {
//        this.name = name;
//    }
}
