package org.example.hibernateType;

import com.alibaba.fastjson.JSONArray;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.jdbc.Size;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.ForeignKeyDirection;
import org.hibernate.type.Type;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Objects;

/**
 * @Description:org.example.hibernateType
 * @Date:2023/11/7
 * @Author:谢锦创
 */
public class JsonArrayType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[]{12};
    }

    @Override
    public Class returnedClass() {
        return JSONArray.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        System.out.println(1111);
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.VARCHAR);
        } else {
            st.setString(index, value.toString()); // 假设这里value可以直接转换为String
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        System.out.println("进行了深拷贝");
//        if (value == null) {
//            return null;
//        }
//        return null;
        // 实现深拷贝逻辑，例如对于JSONArray
        return value;
    }

    @Override
    public boolean isMutable() {
        System.out.println("是否可变类型");
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        System.out.println("进行了disassemble");
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        System.out.println("进行了assemble");
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        System.out.println("进行了replace");
        return original;
    }
}
