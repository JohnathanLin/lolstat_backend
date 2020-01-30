package com.windypath.lolstat.modules.main.dao;

import com.windypath.lolstat.modules.main.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 乔纳森先生
 * @description SysUserMapper
 * @date 2020/1/30 18:59
 */

@Mapper
public interface SysUserMapper {
    /**
     * 获取所有用户信息
     *
     * @return 用户信息列表
     */
    List<SysUser> getAllUser();
}
