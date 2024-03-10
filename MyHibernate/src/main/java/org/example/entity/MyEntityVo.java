package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:org.example.entity
 * @Date:2024/3/10
 * @Author:谢锦创
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyEntityVo {
    private MyEntity myEntity;

    private String exaAttrEntity = "exaAttrEntity";

    private MyClassVo myClassVo;

    public MyEntity MyEntityVoToMyEntity(MyEntityVo myEntityVo) {
        return myEntityVo.getMyEntity();
    }

    public static MyEntityVo getRandomInstance() {
        MyEntityVo myEntityVo = new MyEntityVo();
        myEntityVo.setMyEntity(MyEntity.getRandomInstance());
        myEntityVo.setMyClassVo(MyClassVo.getRandomInstance());
        return myEntityVo;
    }
}
