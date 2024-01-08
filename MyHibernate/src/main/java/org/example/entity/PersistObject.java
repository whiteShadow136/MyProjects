package org.example.entity;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.Data;
import org.example.pojo.Student;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @Description:org.example.entity
 * @Date:2023/11/4
 * @Author:谢锦创
 */
//@Data
@Entity
@Data
public class PersistObject {

    @Id
    int id;

//    @Column(columnDefinition = "jsonb")
//    @Convert
//    @JsonIgnore
//    @JSONField(serialize = false)

//    @Type(type = "org.example.hibernateType.JsonArrayType")
//    @Column(name = "json")
//    private JSONArray json;

    @Embedded
    private Student student;


    public PersistObject(int id, JSONArray json, Student student) {
        this.id = id;
//        this.json = json;
        this.student = student;
    }

    public PersistObject() {
    }

//    @JsonIgnore
    public int getId() {
        return id + 1;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public JSONArray getJson() {
////        return json;
//    }

//    public void setJson(JSONArray json) {
//        this.json = json;
//    }
}
