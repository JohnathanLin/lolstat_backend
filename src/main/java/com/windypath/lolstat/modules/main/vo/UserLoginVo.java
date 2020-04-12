package com.windypath.lolstat.modules.main.vo;

import lombok.*;

/**
 * 用户登录
 *
 * @author 乔纳森先生
 * @description UserLoginVo
 * @date 2020/1/31 11:04
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVo {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
