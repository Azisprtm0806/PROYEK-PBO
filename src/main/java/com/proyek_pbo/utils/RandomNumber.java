package com.proyek_pbo.utils;

public class RandomNumber {

  public static Long getRandom(long min, long max) {
    long number = min + (long) (Math.random() * (max - min));
    return number;
  }

}
