package com.lqr.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertObjUtil {

	/**
	 * @prefix bean and model must need construct without parameter
	 * @param source :the source object with values
	 * @param target :the target object is the new object , non-values
	 * @return target object , which get values from source object
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static Object convertDtoToModel(Object source , Object target) throws SecurityException, NoSuchMethodException,
	IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		//process the source object's values
		Class<?> sourceClass = source.getClass();
		Field [] sourceFields = sourceClass.getDeclaredFields();
		Map<Object,Object> sourceMap = new HashMap<Object,Object>();
		for(Field f : sourceFields){//get the value and name
			String fieldName = f.getName();
			String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			Method getMethod = sourceClass.getMethod(getMethodName, new Class[]{});
			Object fieldValue = getMethod.invoke(source);
			sourceMap.put(fieldName, fieldValue);
		}
		//process the target object ; put the source value in
		Class<?> targetClass = target.getClass();
		Field [] targetFields = targetClass.getDeclaredFields();
		for(Field f : targetFields){
			String fieldName = f.getName();
			Object sourceValue = sourceMap.get(fieldName);
			//process set method
			String setMethodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			//get the Field Type .
			Class<?> fieldClass = f.getType();
			String fieldProp = fieldClass.getName(); //e.g: class java.lang.String 
			Method setMethod = targetClass.getMethod(setMethodName, new Class[]{fieldClass});
			if("java.lang.Integer".equals(fieldProp)){
				sourceValue = (sourceValue == null ? null :sourceValue); //20170302 不处理生成默认内容
				if(sourceValue!=null && !"".equals(sourceValue.toString().trim())){
					setMethod.invoke(target, Integer.parseInt(sourceValue.toString()) );
				}
			} else if("java.lang.String".equals(fieldProp)){
				setMethod.invoke(target, sourceValue);
			} else if("java.sql.Date".equals(fieldProp)){
				sourceValue = (sourceValue == null ? null :sourceValue);//20170302 不处理生成默认内容
				if(sourceValue!=null && !"".equals(sourceValue.toString().trim())){
					setMethod.invoke(target, Date.valueOf(sourceValue.toString()));
				}
			} else if("java.math.BigDecimal".equals(fieldProp)){
				sourceValue = (sourceValue == null ? null :sourceValue);//20170302 不处理生成默认内容
				if(sourceValue!=null && !"".equals(sourceValue.toString().trim())){
					setMethod.invoke(target, new BigDecimal(sourceValue.toString()));
				}
			}
		}
		return target;
	}
	/**
	 * @prefix bean and dto must need construct without parameter
	 * @param source :the source object with values
	 * @param target :the target object is the new object , non-values
	 * @return target object , which get values from source object
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static Object convertModelToDto(Object source , Object target)throws SecurityException, NoSuchMethodException,
	IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		//process the source object's values
		Class<?> sourceClass = source.getClass();
		Field [] sourceFields = sourceClass.getDeclaredFields();
		Map<Object,Object> sourceMap = new HashMap<Object,Object>();
		for(Field f : sourceFields){//get the value and name
			String fieldName = f.getName();
			String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			Method getMethod = sourceClass.getMethod(getMethodName, new Class[]{});
			Object fieldValue = getMethod.invoke(source, (Class[])null);
			sourceMap.put(fieldName, fieldValue);
		}
		//process the target object ; put the source value in
		Class<?> targetClass = target.getClass();
		Field [] targetFields = targetClass.getDeclaredFields();
		for(Field f : targetFields){
			String fieldName = f.getName();
			//20170108 若对应的值为空,则换成空字符.
			Object sourceValue = sourceMap.get(fieldName) == null ? "" :  sourceMap.get(fieldName);
			//process set method
			String setMethodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			//get the Field Type .
			Class<?> fieldClass = f.getType();
			
			Method setMethod = targetClass.getDeclaredMethod(setMethodName, new Class[]{fieldClass});
			setMethod.setAccessible(true);
			setMethod.invoke(target, sourceValue.toString());
		}
		return target;
	}
	
	
	public static void main(String[] args) throws Exception {
		PmsUserInfos p = new PmsUserInfos();
		p.setUserAcct("aaaa");
		p.setUserPassword("bbbbbb");
		p.setUserRole("R01");
		p.setUpdatedDate(Date.valueOf("2017-01-08"));
		
		PmsUserInfosDto dto = new PmsUserInfosDto();
		List<PmsUserInfos> a = new ArrayList<PmsUserInfos>();
		a.add(p);
		
		ConvertObjUtil.convertModelToDto(a.get(0), dto);
		
		System.out.println(dto.getUpdatedDate());
		System.out.println(dto.getUpdatedDate() instanceof String);
	}
}
