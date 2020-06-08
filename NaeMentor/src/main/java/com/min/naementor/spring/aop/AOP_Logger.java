package com.min.naementor.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AOP_Logger {
	public void before(JoinPoint j) {
		Logger log = LoggerFactory.getLogger(j.getTarget()+"");
		log.debug("#################반환완료###################");
		
	}
	//pointcut에서 @afterReturnning
	public void afterReturnning(JoinPoint j) {
		Logger log = LoggerFactory.getLogger(j.getTarget()+"");
		log.debug("###########시작###############3");
		Object[] objs = j.getArgs();
		if(objs!=null) {
			log.debug("Method명: "+j.getSignature().getName());
			for (int i = 0; i < objs.length; i++) {
				log.debug(i+"번째: \t"+objs[i]);
			}
			log.debug("Method명: "+j.getSignature().getName());
		}
	}
	//pointcut에서 @afterThrowing
	public void daoError(JoinPoint j) {
		Logger log = LoggerFactory.getLogger(j.getTarget()+"");
		log.debug("에러:\t"+j.getArgs());
		log.debug("에러:\t"+j.toString());
		
	}
}
