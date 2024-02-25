package org.example.entity;

//import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import org.example.enums.Result;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
//import org.hibernate.annotations.JdbcTypeCode;
//import org.hibernate.type.SqlTypes;


/**
 * @Description:org.example.entity
 * @Date:2023/11/4
 * @Author:谢锦创
 */
//@Data
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Builder
public class PersistObject {

    @Id
    public String id;

    String nameEn;

    LocalDateTime createTime;

    LocalDateTime lastUpdateTime;

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

//    public PersistObject(int id, JSONArray json, Student student) {
//        this.id = id;
////        this.json = json;
//        this.student = student;
//    }

    public PersistObject() {
    }

//    @JsonIgnore
    public String getId() {
        return id + 1;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public JSONArray getJson() {
//        return json;
//    }

//    public void setJson(JSONArray json) {
//        this.json = json;
//    }
}
