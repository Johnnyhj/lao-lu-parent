/**
 * MyService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ai.ge.common.smssend;

import com.ai.ge.common.smssend.bss.FaceResponse;

public interface SmssendService extends java.rmi.Remote {
    FaceResponse sendSMS(String phoneNum, String content);
}
