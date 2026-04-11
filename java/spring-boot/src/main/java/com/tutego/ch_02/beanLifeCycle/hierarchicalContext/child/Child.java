package com.tutego.ch_02.beanLifeCycle.hierarchicalContext.child;

import com.tutego.ch_02.beanLifeCycle.hierarchicalContext.parent.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Child {

    @Autowired
    private Parent parent;

}
