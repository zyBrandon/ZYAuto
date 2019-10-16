package com.zy.mapper;

import com.zy.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface getUserByUsername {
    @Select("select * from user_tbl where username=#{username}")
    User getUserByUsername(@Param("username") String username);
}
