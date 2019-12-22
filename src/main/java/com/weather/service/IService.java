package com.weather.service;

import com.weather.domain.City;
import com.weather.domain.District;
import com.weather.domain.Province;

import java.util.List;

/**
 * FileName: IService.java
 * Author:   chenhao
 * Date:     2019/11/30 22:04
 * Description:
 */

public interface IService {

    List<Province> provinces();

    List<City> cities(Integer pid);

    List<District> districts(Integer cid);

    String result(Integer id);
}
