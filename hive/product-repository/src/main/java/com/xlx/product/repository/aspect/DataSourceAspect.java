package com.xlx.product.repository.aspect;

import com.xlx.product.repository.annotation.DBTypeAnnotation;
import com.xlx.product.repository.config.DBType;
import com.xlx.product.repository.config.DbTypeContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
@Order(0)
public class DataSourceAspect {

    // 必须使用写库的
    @Pointcut("execution(* com.xlx.product.repository.repo..*.save*(..)) || execution(* com.xlx.product.repository.repo..*.insert*(..)) || execution(* com.xlx.product.repository.repo..*.update*(..))")
    public void write(){}

    @Before("write()")
    public void beforeWrite(JoinPoint joinPoint){
        System.out.println("beforeWrite()"+joinPoint.getSignature().getName());
        DbTypeContextHolder.set(DBType.MASTER);
    }

    @After("write()")
    public void afterWrite(JoinPoint joinPoint){
        DbTypeContextHolder.clean();
    }

    // 必须使用读库的
    @Pointcut("execution(* com.xlx.product.repository.repo..*.get*(..))|| execution(* com.xlx.product.repository.repo..*.select*(..))||execution(* com.xlx.product.repository.repo..*.count*(..))")
    public void read(){}

    @Before("read()")
    public void beforeRead(JoinPoint joinPoint){
        DbTypeContextHolder.set(DBType.SLAVE);
    }

    @After("read()")
    public void afterRead(JoinPoint joinPoint){
        DbTypeContextHolder.clean();
    }

    // 服务层有注解的方法特殊处理
    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)" +
            "||@annotation(com.xlx.product.repository.annotation.DBTypeAnnotation)")
    public void readWrite(){}

    @Before("readWrite()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        if(methodSignature.getMethod().isAnnotationPresent(Transactional.class)) DbTypeContextHolder.set(DBType.MASTER);
        if(methodSignature.getMethod().isAnnotationPresent(DBTypeAnnotation.class)) DbTypeContextHolder.setAlwaysWrite();
    }

    @After("readWrite()")
    public void after(JoinPoint joinPoint){
        DbTypeContextHolder.clean();
        DbTypeContextHolder.cleanAlwaysWrite();
    }

}
