package com.renrenche.sales.mismanage.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * "cities":[
 * {
 * "id":6,
 * "name":"东莞",
 * "title":"dongguan",
 * "group":1
 * }
 * ]
 *
 * @author zhangguangliang
 */
@Data
public class CitiesDTO implements Serializable {
    private Integer id;
    private String name;
    private String title;
    private Integer group;
}
