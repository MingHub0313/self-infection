package com.zmm.framework.service;

import top.ibase4j.core.support.scheduler.TaskScheduled;
import top.ibase4j.model.TaskFireLog;

import java.util.List;
import java.util.Map;

/**
 * 定时任务管理
 * @Name SchedulerService
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
public interface SchedulerService {


	/**
	 * 获取所有任务
	 * @return
	 */
	List<TaskScheduled> getAllTaskDetail();

	/**
	 * 执行任务
	 * @param taskScheduler
	 */
	void execTask(TaskScheduled taskScheduler);

	/**
	 * 启停
	 * @param taskScheduler
	 */
	void openTask(TaskScheduled taskScheduler);

	/**
	 * 启停
	 * @param taskScheduler
	 */
	void closeTask(TaskScheduled taskScheduler);

	/**
	 * 删除作业
	 * @param taskScheduler
	 */
	void delTask(TaskScheduled taskScheduler);

	/**
	 * 更新 记录
	 * @param record
	 * @return
	 */
	TaskFireLog updateLog(TaskFireLog record);

	/**
	 * 根据 Id 获取
	 * @param id
	 * @return
	 */
	TaskFireLog getFireLogById(Long id);

	/**
	 * 查询
	 * @param params
	 * @return
	 */
	Object queryLog(Map<String, Object> params);

	/**
	 * 修改执行计划
	 * @param taskScheduled
	 */
	void updateTask(TaskScheduled taskScheduled);
}
