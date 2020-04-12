package com.windypath.lolstat.modules.main.controller;

import com.windypath.lolstat.commons.ResponseCode;
import com.windypath.lolstat.commons.ResponseData;
import com.windypath.lolstat.modules.main.common.RequestHolder;
import com.windypath.lolstat.modules.main.pojo.SysUser;
import com.windypath.lolstat.modules.main.service.SysUserService;
import com.windypath.lolstat.modules.main.vo.SysUserVo;
import com.windypath.lolstat.modules.main.vo.UserLoginVo;
import com.windypath.lolstat.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统管理员登录/忘记密码/退出
 *
 * @author 乔纳森先生
 * @description LoginController
 * @date 2020/1/31 10:56
 */
@Api(value = "AdminController", description = "系统管理员登录、退出、忘记密码")
@RequestMapping("/admin")
@RestController
public class AdminController {
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "系统管理员登录", notes = "系统管理员登录")
    @PostMapping("/login")
    public ResponseData login(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession session) {

        SysUser sysUser = sysUserService.findByUsername(username);

        if (StringUtils.isBlank(username)) {
            return ResponseData.errorMessage("用户名不能为空");
        } else if (StringUtils.isBlank(password)) {
            return ResponseData.errorMessage("登陆密码不能为空");
        } else if (sysUser == null) {
            return ResponseData.errorMessage("查询不到指定用户");
        } else if (!sysUser.getPassword().equals(MD5Util.encode(password))) {
            return ResponseData.errorMessage("用户名或密码错误");
        } else if (!sysUser.getStatus().equals("1")) {
            return ResponseData.errorMessage("用户已被冻结，请联系管理员");
        } else {    // LOGIN SUCCESS
            SysUserVo userVo = new SysUserVo();
            BeanUtils.copyProperties(sysUser, userVo);
            session.setAttribute("user", userVo);
        }

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", session.getId());
        tokenMap.put("userId", sysUser.getId().toString());
        return ResponseData.success(tokenMap);
    }

    @ApiOperation(value = "获取用户基本信息", notes = "获取用户基本信息")
    @RequestMapping("/info")
    public ResponseData getInfo(HttpSession session) {


        SysUserVo userVo = (SysUserVo) session.getAttribute("user");
        return ResponseData.success(userVo);
    }


    @ApiOperation(value = "用户登出接口", notes = "登出操作清空session信息")
    @RequestMapping("/logout")
    public ResponseData logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return ResponseData.successMessage("登出成功");
    }


    @ApiOperation(value = "用户无权限访问时跳转的接口", notes = "用户无权限访问时跳转的接口")
    @RequestMapping("/unauth")
    public ResponseData unauth() {
        return ResponseData.error(ResponseCode.ERROR_LOGIN_NOAUTH.getCode(),
                ResponseCode.ERROR_LOGIN_NOAUTH.getDesc());
    }
}
