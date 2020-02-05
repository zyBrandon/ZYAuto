package com.zy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface getUsernameAndPassMapper {
    @Select("select count(*) from user_tbl where username=#{username} and pass=#{pass}")
    int selectUseranameAndPass(@Param("username") String username,@Param("pass") String pass);
}
