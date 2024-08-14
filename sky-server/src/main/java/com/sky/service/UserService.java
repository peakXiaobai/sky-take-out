package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * @Author: Y-peak
 * @Date: 2024/8/14 16:05 星期三
 * @ProductName: IntelliJ IDEA
 * @ProjectName: sky-take-out
 * @ClassName: UserService
 * @Description:
 */

public interface UserService {

    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
