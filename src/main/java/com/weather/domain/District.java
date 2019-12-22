package com.weather.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * FileName: District.java
 * Author:   chenhao
 * Date:     2019/11/30 21:25
 * Description: 县区
 */
@Entity
@Table(name = "district")
public class District {

    @Id
    @Column(name = "f_id")
    private Integer id;

    @Column(name = "f_province")
    private String province;

    @Column(name = "f_city")
    private String city;

    @Column(name = "f_district")
    private String district;

    @Column(name = "f_pid")
    private Integer pid;

    @Column(name = "f_cid")
    private Integer cid;

    @Column(name = "f_result")
    private String result;

    @Column(name = "f_updatetime")
    @DateTimeFormat(pattern="yyyy-MM-dd:hh-mm")
    @JsonFormat(pattern="yyyy-MM-dd:hh-mm",timezone = "GMT+8")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd:hh-mm")
    @JsonFormat(pattern="yyyy-MM-dd:hh-mm",timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd:hh-mm")
    @JsonFormat(pattern="yyyy-MM-dd:hh-mm",timezone = "GMT+8")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}