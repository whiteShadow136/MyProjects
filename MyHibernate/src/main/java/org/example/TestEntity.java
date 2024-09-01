package org.example;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.config.MyTimestampSerialization;

import java.sql.Timestamp;

/**
 * @Description:PACKAGE_NAME
 * @Date:2024/5/7
 * @Author:谢锦创
 */
@Data
@NoArgsConstructor
public class TestEntity {
    String name;

    @JsonSerialize(using = MyTimestampSerialization.class, nullsUsing = MyTimestampSerialization.class)
    Timestamp lastUpdateTime;
//    = new Timestamp(System.currentTimeMillis());

    public TestEntity(String name) {
        System.out.println("this is MyHibernate");
        this.name = name;
    }
}
