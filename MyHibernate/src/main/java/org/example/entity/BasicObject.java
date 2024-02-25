package org.example.entity;

import lombok.Data;
import org.example.annotation.DynamicEnumCheck;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @Description:org.example.entity
 * @Date:2024/1/29
 * @Author:谢锦创
 */
@Entity
@Data
//@DynamicEnumCheck
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BasicObject extends PersistObject {
    String rdmExtensionType;

}
