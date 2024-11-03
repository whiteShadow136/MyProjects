package org.example.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
        } else {
            JSONObject jsonObject = (JSONObject) value;
            jsonObject.toJavaObject(AAA.class);
            return JSON.parseObject(value.toString(), AAA.class);
//            return parser.parseObject(type);
//            AAA aaa = JSON.parseObject(JSON.toJSONString(value), AAA.class);
//            return aaa; // 新格式直接返回
        }
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
