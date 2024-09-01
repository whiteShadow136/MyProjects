package org.example.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @Description:org.example.config
 * @Date:2024/8/27
 * @Author:谢锦创
 */
public class MyTimestampSerialization extends JsonSerializer<Timestamp> {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    @Override
    public void serialize(Timestamp value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        String format = simpleDateFormat.format(new Timestamp(System.currentTimeMillis()));
        gen.writeString(format);

    }
}
