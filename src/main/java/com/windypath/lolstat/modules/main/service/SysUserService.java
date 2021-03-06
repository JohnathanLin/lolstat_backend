package com.windypath.lolstat.modules.main.service;

import com.windypath.lolstat.modules.main.pojo.SysUser;

import java.util.List;

/**
 * @author 乔纳森先生
 * @description SysUserService
 * @date 2020/1/30 18:06
 */
public interface SysUserService {
    /**
     * 获取所有用户信息
     *
     * @return 用户信息列表
     */
    List<SysUser> getAllUser();

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return 对应的用户
     */
    SysUser findByUsername(String username);
}
