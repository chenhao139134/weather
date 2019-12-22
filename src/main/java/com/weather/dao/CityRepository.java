package com.weather.dao;

import com.weather.domain.City;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * FileName: CityRepository.java
 * Author:   chenhao
 * Date:     2019/11/30 22:02
 * Description:
 */

public interface CityRepository extends CrudRepository<City, String>, JpaSpecificationExecutor<City> {

    @Query("select c from City c where c.id = ?1")
    List<City> queryCities(Integer cid);
}
