package com.yarikonen.web44.ascpect;

import com.yarikonen.web44.Annotations.LogEntryExit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

@Aspect
@Component
public class LogEnrtyExitAspect {
    @Around("@annotation(com.yarikonen.web44.Annotations.LogEntryExit)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable{
        CodeSignature codeSignature= (CodeSignature) pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

        Logger logger = LoggerFactory.getLogger(method.getDeclaringClass());

        //Get Annotation values
        LogEntryExit annotation= method.getAnnotation(LogEntryExit.class);
        LogLevel lvl = annotation.value();
        ChronoUnit unit = annotation.unit();
        boolean showArgs =annotation.showArgs();
        boolean showResult = annotation.showResult();
        boolean showExecutionTime = annotation.showExecutionTime();

        //Get method values
        String methodName = method.getName();
        Object[] args = pjp.getArgs();
        String[] methodParams = codeSignature.getParameterNames();

        log(logger, lvl, entry(methodName, showArgs, methodParams, args));

        var start = Instant.now();
        var response = pjp.proceed();
        var end = Instant.now();
        var duration = String.format("%s %s", unit.between(start, end), unit.name().toLowerCase());

        log(logger, lvl, exit(methodName, duration, response, showResult, showExecutionTime));


        return response;

    }
    static String entry(String methodName, boolean showArgs, String[] params, Object[] args) {
        StringJoiner message = new StringJoiner(" ")
                .add("Started").add(methodName).add("method");
        if (showArgs && Objects.nonNull(params) && Objects.nonNull(args) && params.length == args.length) {
            Map<String, Object> values = new HashMap<>(params.length);
            for (int i = 0; i < params.length; i++) {
                values.put(params[i], args[i]);
            }
            message.add("with args:")
                    .add(values.toString());
        }
        return message.toString();
    }
    static String exit(String methodName, String duration, Object result, boolean showResult, boolean showExecutionTime) {
        StringJoiner message = new StringJoiner(" ")
                .add("Finished").add(methodName).add("method");
        if (showExecutionTime) {
            message.add("in").add(duration);
        }
        if (showResult) {
            message.add("with return:").add(result.toString());
        }
        return message.toString();
    }
    static void log(Logger logger, LogLevel level, String message) {
        switch (level) {
            case DEBUG -> logger.debug(message);
            case TRACE -> logger.trace(message);
            case WARN -> logger.warn(message);
            case ERROR, FATAL -> logger.error(message);
            default -> logger.info(message);
        }
    }

}
