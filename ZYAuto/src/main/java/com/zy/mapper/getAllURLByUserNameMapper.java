package com.zy.mapper;

import com.zy.model.UserURL;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Vector;

@Mapper
public interface getAllURLByUserNameMapper {

    @Select("select * from user_url_tbl where username=#{username}")
    Vector<UserURL> selectURLByUsername(@Param("username") String username);

}
