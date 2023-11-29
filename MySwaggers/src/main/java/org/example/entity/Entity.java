package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:org.example.entity
 * @Date:2023/8/22
 * @Author:谢锦创
 */
@Data
@ApiModel(value = "自定义实体")
public class Entity {

    @ApiModelProperty(value = "主键", name = "主键id", example = "1", hidden = false)
    int id;

    @ApiModelProperty(value = "姓名", name = "姓名", example = "谢锦创", hidden = false)
    String name;
}
