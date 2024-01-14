package org.example.entity;

import com.alibaba.fastjson.JSONArray;
import lombok.Builder;
import lombok.Data;
import org.example.entity.enums.Result;
import org.example.pojo.Student;
//import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;
//import org.hibernate.type.SqlTypes;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * @Description:org.example.entity
 * @Date:2023/11/4
 * @Author:谢锦创
 */
//@Data
@Entity
@Data
//@Builder
public class PersistObject {

    @Id
    @GeneratedValue
    int id;

//    @Column(columnDefinition = "jsonb")
//    @Convert
//    @JsonIgnore
//    @JSONField(serialize = false)

//    @Type(type = "org.example.hibernateType.JsonArrayType")
//    @Column(name = "json")
//    private JSONArray json;

//    @JdbcTypeCode( SqlTypes.JSON )
//    Map<Integer, String> source_cache;
//
//    @Embedded
//    @Nullable
//    private Student student;

//    @JdbcTypeCode( SqlTypes.ARRAY )
//    List<Integer> list;

    Result result;


    public PersistObject(int id, JSONArray json, Student student) {
        this.id = id;
//        this.json = json;
//        this.student = student;
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
//        return json;
//    }

//    public void setJson(JSONArray json) {
//        this.json = json;
//    }
}
