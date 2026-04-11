package com.tutego.ch_02.beanLifeCycle.hierarchicalContext.parent;

import org.springframework.stereotype.Component;

@Component
public class Parent {

    // hierarchical context makes such a wiring illegal
    // @Autowired private Child child;
}
