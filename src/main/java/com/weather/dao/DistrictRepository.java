package com.weather.dao;

import com.weather.domain.District;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * FileName: DistrictRepository.java
 * Author:   chenhao
 * Date:     2019/11/30 22:03
 * Description:
 */

public interface DistrictRepository extends CrudRepository<District, String>, JpaSpecificationExecutor<District> {

    @Query("select d from District d where  d.cid=?1")
    List<District> queryDistricts(Integer cid);

    @Query("select d from District d where  d.id=?1")
    District queryDistrictsById(Integer id);
}
