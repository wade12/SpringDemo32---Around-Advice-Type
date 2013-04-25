package com.osgo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect
{
	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint)
	{	
	} // end method loggingAdvice
	
	
	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void stringArgumentMethod(String name, Object returnString)
	{
		System.out.println("A method that takes String arguments has been called.  The value is: " + name);
		System.out.println("The output value is: " + returnString);
	} // end method stringArgumentMethod
	
	
	@AfterThrowing(pointcut="args(name)", throwing="exception")
	public void exceptionAdvice(String name, Exception exception)
	{
		System.out.println("An exception has been thrown:" + (exception));
	} // end method exceptionAdvice
	
	
	@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
		Object returnValue = null;
		try
		{
			System.out.println("Before Advice.");
			returnValue = proceedingJoinPoint.proceed();					// target method execution
			System.out.println("After Returning.");
		}
		catch (Throwable exception)
		{
			System.out.println("After Throwing.");
		}
		
		System.out.println("After Finally.");
		return returnValue;
		
	} // end method myAroundAdvice
	
	
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
	} // end dummy method allGetters
	
	
	@Pointcut("within(com.osgo.model.Circle)")						
	public void allCircleMethods()
	{
	} // end dummy method allCircleMethods()
		
	
} // end Class LoggingAspect
