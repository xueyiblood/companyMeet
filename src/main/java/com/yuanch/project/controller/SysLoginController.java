package com.yuanch.project.controller;


import com.yuanch.common.constant.Constants;
import com.yuanch.common.utils.ServletUtils;
import com.yuanch.common.web.domain.AjaxResult;
import com.yuanch.common.web.domain.entity.SysUser;
import com.yuanch.common.web.domain.model.LoginBody;
import com.yuanch.common.web.domain.model.LoginUser;
import com.yuanch.common.web.service.SysLoginService;
import com.yuanch.common.web.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * 登录验证
 * 
 * @author sj
 */
@RestController
@Api("登录接口")
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

//    @Autowired
//    private ISysMenuService menuService;
//
//    @Autowired
//    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @ApiOperation(value = "登录接口")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @ApiOperation(value = "获取登录用户信息")
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
//        // 角色集合
//        Set<String> roles = permissionService.getRolePermission(user);
//        // 权限集合
//        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
//        ajax.put("roles", roles);
//        ajax.put("permissions", permissions);
        ajax.put("roles", "");
        ajax.put("permissions", "");
        return ajax;
    }

//    /**
//     * 获取路由信息
//     *
//     * @return 路由信息
//     */
//    @GetMapping("getRouters")
//    public AjaxResult getRouters()
//    {
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        // 用户信息
//        SysUser user = loginUser.getUser();
//        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());
//        return AjaxResult.success(menuService.buildMenus(menus));
//    }
}
