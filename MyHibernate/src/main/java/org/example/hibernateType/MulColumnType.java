package org.example.hibernateType;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.jdbc.Size;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.ForeignKeyDirection;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

/**
 * @Description:org.example.hibernateType
 * @Date:2023/11/7
 * @Author:谢锦创
 */
public class MulColumnType implements Type {
    @Override
    public boolean isAssociationType() {
        return false;
    }

    @Override
    public boolean isCollectionType() {
        return false;
    }

    @Override
    public boolean isEntityType() {
        return false;
    }

    @Override
    public boolean isAnyType() {
        return false;
    }

    @Override
    public boolean isComponentType() {
        return false;
    }

    @Override
    public int getColumnSpan(Mapping mapping) throws MappingException {
        return 1;
    }

    @Override
    public int[] sqlTypes(Mapping mapping) throws MappingException {
        return new int[] {Types.VARCHAR};
    }

    @Override
    public Size[] dictatedSizes(Mapping mapping) throws MappingException {
        return new Size[0];
    }

    @Override
    public Size[] defaultSizes(Mapping mapping) throws MappingException {
        return new Size[1];
    }

    @Override
    public Class getReturnedClass() {
        return MulColumnType.class;
    }

    @Override
    public boolean isSame(Object x, Object y) throws HibernateException {
        return false;
    }

    @Override
    public boolean isEqual(Object x, Object y) throws HibernateException {
        return false;
    }

    @Override
    public boolean isEqual(Object x, Object y, SessionFactoryImplementor factory) throws HibernateException {
        return false;
    }

    @Override
    public int getHashCode(Object x) throws HibernateException {
        return 0;
    }

    @Override
    public int getHashCode(Object x, SessionFactoryImplementor factory) throws HibernateException {
        return 0;
    }

    @Override
    public int compare(Object x, Object y) {
        return 0;
    }

    @Override
    public boolean isDirty(Object old, Object current, SharedSessionContractImplementor session) throws HibernateException {
        return false;
    }

    @Override
    public boolean isDirty(Object oldState, Object currentState, boolean[] checkable, SharedSessionContractImplementor session) throws HibernateException {
        return false;
    }

    @Override
    public boolean isModified(Object dbState, Object currentState, boolean[] checkable, SharedSessionContractImplementor session) throws HibernateException {
        return false;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        return 1;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String name, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        return 1;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, boolean[] settable, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        System.out.println(1111);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        System.out.println(2222);
    }

    @Override
    public String toLoggableString(Object value, SessionFactoryImplementor factory) throws HibernateException {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Object deepCopy(Object value, SessionFactoryImplementor factory) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value, SharedSessionContractImplementor session, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, SharedSessionContractImplementor session, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public void beforeAssemble(Serializable cached, SharedSessionContractImplementor session) {

    }

    @Override
    public Object hydrate(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        return null;
    }

    @Override
    public Object resolve(Object value, SharedSessionContractImplementor session, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object semiResolve(Object value, SharedSessionContractImplementor session, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Type getSemiResolvedType(SessionFactoryImplementor factory) {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, SharedSessionContractImplementor session, Object owner, Map copyCache) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, SharedSessionContractImplementor session, Object owner, Map copyCache, ForeignKeyDirection foreignKeyDirection) throws HibernateException {
        return null;
    }

    @Override
    public boolean[] toColumnNullness(Object value, Mapping mapping) {
        return new boolean[0];
    }
}
