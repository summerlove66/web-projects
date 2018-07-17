package com.park.AOP;

import com.park.model.Result;
import com.park.utils.JWTUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import java.util.Arrays;


//@Component
//@Aspect
public class AuthAop {

    @Around("@annotation(com.park.AOP.CheckJwt)")
    public Result authProcess(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("---"+ Arrays.asList(proceedingJoinPoint.getArgs()));
        try {
            if (proceedingJoinPoint.getArgs().length > 0) {
                JWTUtils.parseJWT(proceedingJoinPoint.getArgs()[0] + "");
            }
            return (Result) proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());

        } catch (Exception e) {
            return new Result(0, "token 出错");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return new Result(0, "不明");
        }

    }

}
