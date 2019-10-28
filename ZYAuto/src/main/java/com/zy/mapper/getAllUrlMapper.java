package com.zy.mapper;

import com.zy.model.User;
import com.zy.model.UserURL;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Vector;
@Mapper
public interface getAllUrlMapper {
    @Select("select * from user_url_tbl")
    Vector<UserURL> getAllUrl();
}
