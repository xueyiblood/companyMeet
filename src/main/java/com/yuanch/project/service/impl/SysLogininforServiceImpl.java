package com.yuanch.project.service.impl;


import com.yuanch.common.web.domain.entity.SysLogininfor;
import com.yuanch.project.mapper.komo.SysLogininforMapper;
import com.yuanch.project.service.SysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 系统访问日志情况信息 服务层处理
 *
 * @author sj
 */
@Service
public class SysLogininforServiceImpl implements SysLogininforService {

    @Autowired
    private SysLogininforMapper logininforMapper;

    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    @Override
    @Transactional(transactionManager = "komoTransactionManager")
    public void insertLogininfor(SysLogininfor logininfor)
    {
        logininforMapper.insertLogininfor(logininfor);
    }

    /**
     * 查询系统登录日志集合
     *
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    @Override
    @Transactional(transactionManager = "komoTransactionManager")
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor)
    {
        return logininforMapper.selectLogininforList(logininfor);
    }

    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return
     */
    @Override
    @Transactional(transactionManager = "komoTransactionManager")
    public int deleteLogininforByIds(Long[] infoIds)
    {
        return logininforMapper.deleteLogininforByIds(infoIds);
    }

    /**
     * 清空系统登录日志
     */
    @Override
    @Transactional(transactionManager = "komoTransactionManager")
    public void cleanLogininfor()
    {
        logininforMapper.cleanLogininfor();
    }

}
