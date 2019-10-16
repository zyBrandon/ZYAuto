package com.zy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface getUserUrlHaveMapper {
    @Select("select count(*) from user_url_tbl where username=#{username} and url=#{url}")
    int selectUrlByUsername(@Param("username") String username,@Param("url") String url);
}
