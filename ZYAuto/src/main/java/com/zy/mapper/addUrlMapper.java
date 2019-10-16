package com.zy.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface addUrlMapper {
    @Insert("insert into user_url_tbl(username,url) values(#{username},#{url})")
    int addUrl(@Param("username") String username,@Param("url") String url);
}
