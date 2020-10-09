package com.yuanch.common.web.service;

import com.yuanch.common.constant.Constants;
import com.yuanch.common.exception.CustomException;
import com.yuanch.common.exception.UserPasswordNotMatchException;
import com.yuanch.common.manager.ScheduledManager;
import com.yuanch.common.manager.factory.ScheduledFactory;
import com.yuanch.common.web.domain.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录校验方法
 * 
 * @author sj
 */
@Component
public class SysLoginService
{
    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 登录验证
     * 
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid)
    {
        // 用户验证
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e)
        {
            if (e instanceof BadCredentialsException)
            {
                ScheduledManager.me().execute(ScheduledFactory.recordLogininfor(username, Constants.LOGIN_FAIL, "用户名或密码错误"));
                throw new UserPasswordNotMatchException();
            }
            else
            {
                ScheduledManager.me().execute(ScheduledFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new CustomException(e.getMessage());
            }
        }
        ScheduledManager.me().execute(ScheduledFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, "登录成功"));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 生成token
        return tokenService.createToken(loginUser);
    }
}
