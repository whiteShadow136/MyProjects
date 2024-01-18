package org.example.entity;

//import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import org.example.enums.Result;
//import org.hibernate.annotations.JdbcTypeCode;
//import org.hibernate.type.SqlTypes;


/**
 * @Description:org.example.entity
 * @Date:2023/11/4
 * @Author:谢锦创
 */
//@Data
@Data
//@Builder
public class PersistObject {

    String id;

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

    String nameEn;

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
