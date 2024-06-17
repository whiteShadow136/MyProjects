package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.vo.UserVo;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVoTest extends BasicObject{

    @Type(type = "org.example.hibernateType.UserVoType")
    private UserVo userVo;

    @Column
    private String email;

}
