package com.ai.ge.test;

import org.springframework.stereotype.Service;

/**
 * Created by zhacy3 on 2017/5/3.
 */
@Service
public class Test01 {
    private String a;
    private int b;
    private Long c;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Long getC() {
        return c;
    }

    public void setC(Long c) {
        this.c = c;
    }

    public void test(){
        System.out.println("this is Test01.test()");
    }
}
