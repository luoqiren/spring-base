package com.lqr.spring.lifecycle;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
/**
 * nstantiationAwareBeanPostProcessor 接口本质是BeanPostProcessor的子接口，
 * 一般我们继承Spring为其提供的适配器类InstantiationAwareBeanPostProcessorAdapter来使用它
 * @author lqr
 *
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

	
	
	public MyInstantiationAwareBeanPostProcessor() {
		System.out.println("这是MyInstantiationAwareBeanPostProcessor 实现"
				+ "InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");  
	}

	@Override
	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
		return super.determineCandidateConstructors(beanClass, beanName);
	}

	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		return super.getEarlyBeanReference(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return super.postProcessAfterInitialization(bean, beanName);
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//		System.out.println("InstantiationAwareBeanPostProcessor调用postProcessAfterInstantiation方法");  
		if("car".equals(beanName)){
			System.out.println("InstantiationAware BeanPostFactory.postProcess AfterInstantiation");
			
		}
		return true;
	}

	@Override//实例化bean前调用
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");  
		if("car".equals(beanName)){
			System.out.println("InstantiationAware BeanPostFactory.postProcess BeforeInstantiation");
			
		}
		return super.postProcessBeforeInitialization(bean, beanName) ;
	}

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		
		return super.postProcessBeforeInstantiation(beanClass, beanName);
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
//		System.out.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
		if("car".equals(beanName)){
			System.out.println("InstantiationAware BeanPostFactory.postProcess postProcessPropertyValues");
			
		}
		return pvs;
	}

	@Override
	public Class<?> predictBeanType(Class<?> beanClass, String beanName) {
		return super.predictBeanType(beanClass, beanName);
	}

}
