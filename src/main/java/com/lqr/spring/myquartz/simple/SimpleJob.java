package com.lqr.spring.myquartz.simple;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {
	private int i=0;
	@Override
	public void execute(JobExecutionContext jobCtx) throws JobExecutionException {
		System.out.println(jobCtx.getTrigger().getName()+" trigger time is:"+ new Date());
		System.out.println(++i);
	}

}
