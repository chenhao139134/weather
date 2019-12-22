package com.weather.dao;

import com.weather.domain.Province;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * FileName: ProvinceRepository.java
 * Author:   chenhao
 * Date:     2019/11/30 22:02
 * Description:
 */

public interface ProvinceRepository extends CrudRepository<Province, String>, JpaSpecificationExecutor<Province> {

    @Query("select p from Province p")
    List<Province> provinces();
}
