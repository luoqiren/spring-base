package com.lqr.spring.myquartz.simple;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleConTriggerRunner {

	public static void main(String[] args) {
		String jobName="job2_1";
		String jobGroup="jgroup2";
		String triggerName="trigger2_1";
		String triggerGroup="tgroup2";
		
		try{
			//创建一个jobdetail实例，指定使用SimpleJob
			JobDetail jobDetail = new JobDetail(jobName, jobGroup, SimpleJob.class);
			
			//通过simpletrigger定义的调度规则， 马上启动， 2秒运行一次
			CronTrigger cronTrigger = new CronTrigger(triggerName, triggerGroup);
			CronExpression cronExpression = new CronExpression("0/2 * * * * ?");
			cronTrigger.setCronExpression(cronExpression);
			
			//通过SchedulerFactory获取调度器实例
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, cronTrigger);//注册并进行调度
			scheduler.start();//调度启动
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
