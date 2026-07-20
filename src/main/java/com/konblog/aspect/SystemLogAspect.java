package com.konblog.aspect;
import com.konblog.annotation.SystemLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SystemLogAspect {
    private static final Logger log = LoggerFactory.getLogger(SystemLogAspect.class);

    @Pointcut("@annotation(com.konblog.annotation.SystemLog)")
    public void pt() {}

    @Around("pt()")
    public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object ret;
        try { ret = pjp.proceed(); }
        finally {
            long cost = System.currentTimeMillis() - start;
            MethodSignature sig = (MethodSignature) pjp.getSignature();
            SystemLog ann = sig.getMethod().getAnnotation(SystemLog.class);
            String desc = ann != null ? ann.value() : "";
            String method = sig.getDeclaringType().getSimpleName() + "." + sig.getMethod().getName();
            log.info("[AOP] {} {} cost={}ms", method, desc, cost);
        }
        return ret;
    }
}