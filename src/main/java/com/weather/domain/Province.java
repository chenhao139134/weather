package com.weather.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName: Province.java
 * Author:   chenhao
 * Date:     2019/11/30 21:21
 * Description: 省
 */
@Entity
@Table(name = "province")
public class Province {

    @Id
    @Column(name = "f_id")
    private Integer id;

    @Column(name = "f_name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}