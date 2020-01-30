package com.windypath.lolstat.modules.main.controller;

import com.windypath.lolstat.commons.ResponseData;

import com.windypath.lolstat.modules.main.pojo.SysUser;
import com.windypath.lolstat.modules.main.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/")
@RestController
public class MainController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("/hello")
    public ResponseData hello() {
        List<SysUser> userList = sysUserService.getAllUser();
        return ResponseData.success(userList);
    }
    @RequestMapping("/")
    public ResponseData root() {

        return ResponseData.success("root!");
    }
}
