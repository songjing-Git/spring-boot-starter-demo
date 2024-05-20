package com.songjing.sbsd.annotation.run.limit;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AccessLimitInterceptor implements HandlerInterceptor {

    private AtomicInteger count;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        AccessLimit accessLimit = handlerMethod.getMethodAnnotation(AccessLimit.class);
        if (accessLimit == null) {
            return true;
        }
        int limit = accessLimit.limit();
        int seconds = accessLimit.seconds();
        count.incrementAndGet();
        return count.get() <= limit;
    }
}
