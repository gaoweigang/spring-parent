package com.gwg.aspect;

@Aspect
public class AspectTest {

    @Pointcut
    public void test(){

    }

    public void beforeTest(){
        System.out.println("beforeTest");
    }
}
