package com.zy.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface addResultMapper {
    @Insert("insert into url_result(url,res,operator,operator_time) values(#{url},#{res},#{operator},#{operator_time})")
    int addResult(@Param("url") String url,@Param("res")String res,@Param("operator")String operator,@Param("operator_time") String operator_time);
}
