package com.windypath.lolstat.modules.main.service;

import com.windypath.lolstat.modules.main.dao.SysUserMapper;
import com.windypath.lolstat.modules.main.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 乔纳森先生
 * @description SysUserServiceImpl
 * @date 2020/1/30 18:57
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getAllUser() {
        return sysUserMapper.getAllUser();
    }

    @Override
    public SysUser findByUsername(String username) {
        return sysUserMapper.findByUsername(username);

    }
}
