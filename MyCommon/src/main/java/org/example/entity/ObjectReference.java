package org.example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @Description:org.example.entity
 * @Date:2024/2/5
 * @Author:谢锦创
 */
@Data
public class ObjectReference<T extends PersistObject> {

    String id;

    String clazz;

    @JsonIgnore
    @JSONField(serialize = false, deserialize = false)
    T referenceObject;
}
