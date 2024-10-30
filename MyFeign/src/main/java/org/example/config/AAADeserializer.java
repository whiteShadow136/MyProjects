package org.example.config;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import org.example.entity.AAA;

import java.lang.reflect.Type;

public class AAADeserializer implements ObjectDeserializer {
    @Override
    public AAA deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        Object value = parser.parse();
        if (value instanceof String) {
            AAA aaa = new AAA(value.toString());
            return aaa;
        } else if (value instanceof AAA) {
            return null; // 新格式直接返回
        }
        return null;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
