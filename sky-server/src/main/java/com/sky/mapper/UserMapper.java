package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Y-peak
 * @Date: 2024/8/14 16:32 星期三
 * @ProductName: IntelliJ IDEA
 * @ProjectName: sky-take-out
 * @ClassName: UserMapper
 * @Description:
 */
@Mapper
public interface UserMapper {
    /**
     * 根据Openid查询User
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    User getByOpenid(String openid);

    /**
     * 插入新用户，并且设置id
     * @param user
     */
    void insert(User user);
}
