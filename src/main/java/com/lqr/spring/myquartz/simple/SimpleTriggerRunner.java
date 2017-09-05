package com.lqr.spring.myquartz.simple;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerRunner {

	public static void main(String[] args) {
		String jobName="job1_1";
		String jobGroup="jgroup1";
		String triggerName="trigger1_1";
		String triggerGroup="tgroup1";
		try{
			//创建一个jobdetail实例，指定使用SimpleJob
			JobDetail jobDetail = new JobDetail(jobName, jobGroup, SimpleJob.class);
			
			//通过simpletrigger定义的调度规则， 马上启动， 2秒运行一次， 共运行100次
			SimpleTrigger simpleTrigger = new SimpleTrigger(triggerName, triggerGroup);
			simpleTrigger.setStartTime(new Date());
			simpleTrigger.setRepeatInterval(2000);
			simpleTrigger.setRepeatCount(100);
			//通过SchedulerFactory获取调度器实例
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, simpleTrigger);//注册并进行调度
			scheduler.start();//调度启动
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
