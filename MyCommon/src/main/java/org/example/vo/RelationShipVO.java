package org.example.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Cascade;

import java.io.Serializable;

/**
 * @Description:org.example.vo
 * @Date:2023/12/25
 * @Author:谢锦创
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RelationShipVO implements Serializable {
    Class srcClass;

    String srcAttr;

    Class targetClass;

    String targetAttr;

    Cascade[] cascades;
}
