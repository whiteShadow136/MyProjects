package org.example.entity;

import lombok.Data;
import org.example.annotation.DynamicEnumCheck;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Description:org.example.entity
 * @Date:2024/1/29
 * @Author:谢锦创
 */
@Entity
@Data
@DynamicEnumCheck
public abstract class BasicObject extends PersistObject {
    String rdmExtensionType;

}
