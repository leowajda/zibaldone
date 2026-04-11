package com.tutego.ch_02.configurationClasses.injectionPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomComponent {

    @Autowired
    @CryptographicallyStrong
    private Random random;

    @Autowired
    @CryptographicallyStrong
    public void setRandom(Random random) {
        this.random = random;
    }

}

