package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * @Description:org.example.entity
 * @Date:2024/3/10
 * @Author:谢锦创
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyClassVo {
    SysClass sysClass;

    String exaAttrClass = "exaAttrClass";

    public SysClass getMyClassVoToSysClass(MyClassVo myClassVo) {
        return myClassVo.getSysClass();
    }

    public static MyClassVo getRandomInstance() {
        MyClassVo myClassVo = new MyClassVo();
        myClassVo.setSysClass(SysClass.getRandomInstance());
        return myClassVo;
    }
}
