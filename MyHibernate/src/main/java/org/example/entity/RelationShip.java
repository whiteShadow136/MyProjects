package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Description:org.example.entity
 * @Date:2024/1/20
 * @Author:谢锦创
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelationShip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    Class srcClass;

    String srcClassNameEn;

    Class targetClass;

    String targetClassNameEn;
}
