package com.zy.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface deleteUrlMapper {
    @Delete("delete from user_url_tbl where username=#{username} and url=#{url}")
    int deleteUrl(@Param("username") String username,@Param("url") String url);
}
