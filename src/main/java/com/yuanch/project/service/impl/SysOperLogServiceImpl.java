package com.yuanch.project.service.impl;

import com.yuanch.common.web.domain.entity.SysOperLog;
import com.yuanch.project.mapper.komo.SysOperLogMapper;
import com.yuanch.project.service.SysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 操作日志 服务层处理
 * 
 * @author sj
 */
@Service
public class SysOperLogServiceImpl implements SysOperLogService
{

    @Autowired
    private SysOperLogMapper operLogMapper;

    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    @Override
    @Transactional(transactionManager = "komoTransactionManager")
    public void insertOperlog(SysOperLog operLog)
    {
        operLogMapper.insertOperlog(operLog);
    }

    /**
     * 查询系统操作日志集合
     *
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    @Override
    @Transactional(transactionManager = "komoTransactionManager")
    public List<SysOperLog> selectOperLogList(@RequestBody SysOperLog operLog)
    {
        return operLogMapper.selectOperLogList(operLog);
    }

    /**
     * 批量删除系统操作日志
     *
     * @param operIds 需要删除的操作日志ID
     * @return 结果
     */
    @Override
    @Transactional(transactionManager = "komoTransactionManager")
    public int deleteOperLogByIds(Long[] operIds)
    {
        return operLogMapper.deleteOperLogByIds(operIds);
    }

    /**
     * 查询操作日志详细
     *
     * @param operId 操作ID
     * @return 操作日志对象
     */
    @Override
    @Transactional(transactionManager = "komoTransactionManager")
    public SysOperLog selectOperLogById(Long operId)
    {
        return operLogMapper.selectOperLogById(operId);
    }

    /**
     * 清空操作日志
     */
    @Override
    @Transactional(transactionManager = "komoTransactionManager")
    public void cleanOperLog()
    {
        operLogMapper.cleanOperLog();
    }
}
