package org.example.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description:org.example.entity
 * @Date:2024/10/15
 * @Author:谢锦创
 */
//@AllArgsConstructor
//@NoArgsConstructor
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
    public AAA(String aaa) {
        this.aaa = aaa;
    }

//    @JsonCreator
    public AAA(@JsonProperty("aaa") String aaa,@JsonProperty("bbb") String bbb) {
        this.aaa = aaa;
        this.bbb = bbb;
    }
}
