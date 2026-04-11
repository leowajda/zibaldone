package com.tutego.ch_04.proxyPattern;

import org.aopalliance.intercept.MethodInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class ProxyApplication {

    private static final Logger logger = LoggerFactory.getLogger(ProxyApplication.class);

    public static void main(String... args) {
        ProxyFactory factory = new ProxyFactory(new ArrayList<>());

        MethodInterceptor methodInterceptor = invocation -> {
            if (invocation.getMethod().getName().equals("add") && isNull(invocation.getArguments()[0])) {
                logger.info("proxy has intercepted invalid method call");
                return false;
            }
            return invocation.proceed();
        };

        factory.addAdvice(methodInterceptor);

        List unsafeList = (List) factory.getProxy();
        unsafeList.add("One");
        logger.info("unsafeList contents: {}", unsafeList);
        unsafeList.add(null);
        unsafeList.add("Two");
        logger.info("unsafeList contents: {}", unsafeList);
    }

}
