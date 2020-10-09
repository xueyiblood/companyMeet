package com.yuanch.common.manager.factory;

import com.sun.nio.sctp.MessageInfo;
import com.yuanch.common.constant.Constants;
import com.yuanch.common.utils.LogUtils;
import com.yuanch.common.utils.SpringBeanUtils;
import com.yuanch.common.web.domain.entity.SysLogininfor;
import com.yuanch.common.web.domain.entity.SysOperLog;
import com.yuanch.project.service.SysLogininforService;
import com.yuanch.project.service.SysOperLogService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 * @author sj
 */
public class ScheduledFactory {
    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

    /**
     * 记录登陆信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息
     * @param args     列表
     * @return 任务task
     */
    public static TimerTask recordLogininfor(final String username, final String status, final String message,
                                             final Object... args) {
        return new TimerTask() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印信息到日志
                sys_user_logger.info(s.toString(), args);
                // 封装对象
                SysLogininfor logininfor = new SysLogininfor();
                logininfor.setUserName(username);
                logininfor.setPersonType("警员");
                logininfor.setPlatform("PC");
                logininfor.setMsg(StringUtils.substring(message, 0, 2000));
                // 日志状态
                if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
                    logininfor.setStatus(Constants.SUCCESS);
                } else if (Constants.LOGIN_FAIL.equals(status)) {
                    logininfor.setStatus(Constants.FAIL);
                }
                // 插入数据
                SpringBeanUtils.getBean(SysLogininforService.class).insertLogininfor(logininfor);
            }
        };
    }

    /**
     * 操作日志记录
     *
     * @param operLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final SysOperLog operLog) {
        return new TimerTask() {
            @Override
            public void run() {
                SpringBeanUtils.getBean(SysOperLogService.class).insertOperlog(operLog);
            }
        };
    }

}
