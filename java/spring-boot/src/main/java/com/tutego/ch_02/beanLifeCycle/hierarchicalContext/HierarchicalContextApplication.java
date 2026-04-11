package com.tutego.ch_02.beanLifeCycle.hierarchicalContext;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootConfiguration
@EnableAutoConfiguration
public class HierarchicalContextApplication {

    @Configuration(proxyBeanMethods = false)
    @ComponentScan("com.tutego.ch_02.beanLifeCycle.hierarchicalContext.parent")
    public static class ParentConfig {}

    @Configuration(proxyBeanMethods = false)
    @ComponentScan("com.tutego.ch_02.beanLifeCycle.hierarchicalContext.child")
    public static class ChildConfig {}

    public static void main(String... args) {
        new SpringApplicationBuilder()
                .parent(ParentConfig.class)
                .child(ChildConfig.class)
                .run(args);
    }

}
