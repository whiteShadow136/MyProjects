package org.example.entity;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.config.AAADeserializer;

/**
 * @Description:org.example.entity
 * @Date:2024/10/15
 * @Author:谢锦创
 */
@NoArgsConstructor
@AllArgsConstructor
@JSONType(deserializer = AAADeserializer.class)
@Data
public class AAA {

    String aaa;

    String bbb;

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }

    //    @JsonCreator
//    public AAA(@JsonProperty("name") String aaa) {
//        this.aaa = aaa;
//    }

//    @JsonCreator
//    public AAA(@JsonProperty("name")String aaa) {
//        this.aaa = aaa;
//    }

//    @JsonCreator
//    public AAA(String aaa) {
//        this.aaa = aaa;
//    }

//    @JSONCreator
//    public AAA(@JSONField(name = "name") Object name) {
//        if (name instanceof String) {
//            this.aaa = (String) name;  // 如果旧数据是 String 类型，将其赋值给 aaa
//        } else if (name instanceof AAA) {
//            AAA oldData = (AAA) name;
//            this.aaa = oldData.aaa;
//            this.bbb = oldData.bbb;
//        }
//    }

    public AAA(String name) {
        this.aaa = name;  // 如果旧数据是 String 类型，将其赋值给 aaa
    }

//    public AAA(@JsonProperty("aaa") String aaa,@JsonProperty("bbb") String bbb) {
//        this.aaa = aaa;
//        this.bbb = bbb;
//    }

//    @JSONField(name = "name")
//    public void setName(Object value) {
//        if (value instanceof String) {
//            this.aaa = (String) value;
//        } else if (value instanceof AAA) {
//            AAA oldData = (AAA) value;
//            this.aaa = oldData.aaa;
//            this.bbb = oldData.bbb;
//        }
//    }

}
