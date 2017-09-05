package com.lqr.test;

public class TestException {

	public static void main(String[] args) {
		int max = 8;
		for (int i=0; i<max; i++){
			try{
				
				if(i==5){
					throw new Exception("i:"+i+"人为异常");
				}
				System.out.println("i:"+i);
			}catch(Exception e){
				
				System.out.println("我抓住异常了");
				e.printStackTrace();
				
			}
			
			
			
		}
		
		
		
	}

}
