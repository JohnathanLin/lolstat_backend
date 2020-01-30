package com.windypath.lolstat.modules.main.vo;

import lombok.*;

import java.util.Date;

/**
 * 系统用户
 *
 * @author 乔纳森先生
 * @description SysUserVo
 * @date 2020/1/30 18:55
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SysUserVo {
    /**
     * ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 手机电话
     */
    private String mobile;
    /**
     * Email
     */
    private String email;
    /**
     * 用户状态
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date operateTime;
    /**
     * 备注
     */
    private String remark;
}
