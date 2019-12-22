package com.weather.service.impl;

import com.weather.dao.CityRepository;
import com.weather.dao.DistrictRepository;
import com.weather.dao.ProvinceRepository;
import com.weather.domain.City;
import com.weather.domain.District;
import com.weather.domain.Province;
import com.weather.service.IService;
import com.weather.support.WeatherReportByCity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * FileName: ServiceImpl.java
 * Author:   chenhao
 * Date:     2019/11/30 22:06
 * Description:
 */
@Service
public class ServiceImpl implements IService {

    @Autowired
    ProvinceRepository proDao;

    @Autowired
    CityRepository cityDao;

    @Autowired
    DistrictRepository disDao;

    @Override
    public List<Province> provinces() {
        List<Province> list = proDao.provinces();
        return list;
    }

    @Override
    public List<City> cities(Integer pid) {

        List<City> list = cityDao.queryCities(pid);
        return list;
    }

    @Override
    public List<District> districts(Integer cid) {
        List<District> list = disDao.queryDistricts(cid);
        return list;
    }

    @Override
    public String result(Integer id) {
        District district = disDao.queryDistrictsById(id);

        if(district != null){
            int updateTime = district.getUpdateTime().getMinutes();
            int now = new Date().getMinutes();
            if(now - updateTime <= 30){
                return district.getResult();
            }else{
                String str = WeatherReportByCity.GetTodayTemperatureByCity(id);
                if(!StringUtils.isEmpty(str)){
                    district.setResult(str);
                    district.setUpdateTime(new Date());
                    disDao.save(district);
                    return str;
                }
            }

        }
        return "";
    }
}