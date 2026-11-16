package com.tutego.ch_02.configurationClasses.injectionPoint;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
