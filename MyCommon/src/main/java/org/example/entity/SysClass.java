package org.example.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @Description:org.example.entity
 * @Date:2023/12/20
 * @Author:谢锦创
 */
@Data
@Builder
public class SysClass {
    private Integer id;
    private String name;
    private String teacher;
    private String classRoom;
    private String classTime;
    private String classWeek;
    private Student student;
}
