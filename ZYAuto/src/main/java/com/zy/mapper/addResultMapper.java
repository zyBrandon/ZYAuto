package com.zy.mapper;

import org.apache.ibatis.annotations.Insert;

public interface addResultMapper {
    @Insert("insert into url_result(url,res,operator,operator_time) values()")
    int addResult();
}
