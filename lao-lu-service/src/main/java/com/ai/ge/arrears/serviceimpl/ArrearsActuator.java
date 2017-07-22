package com.ai.ge.arrears.serviceimpl;

import com.ai.ge.arrears.service.ArrearsService;

/**
 * Created by Sam on 17/5/24.
 */
public class ArrearsActuator implements Runnable{

    private String arreasString;
    private String redisFlag;
    private ArrearsService arrearsService;

    public ArrearsActuator(String arreasString, String redisFlag, ArrearsService arrearsService) {
        this.arreasString = arreasString;
        this.redisFlag = redisFlag;
        this.arrearsService = arrearsService;
    }

    @Override
    public void run() {
        arrearsService.actuator(arreasString,redisFlag);
    }
}
